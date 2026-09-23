# Guía de Query Methods

## Estructura

```
[acción] [Distinct] [Top/First N] By [criterios con And/Or] [OrderBy campo Asc/Desc]
```
Ejemplo: `findDistinctTop5ByCountry_NameAndActiveTrueOrderByFoundedDesc(String nombre)`

## 1. Acción (lo que devuelve)

| Prefijo | Para qué sirve | Retorno típico |
|---|---|---|
| `find...By` (también `read`, `get`, `query`, `search`, `stream`) | Traer datos | `List<T>`, `Optional<T>`, `T`, `Page<T>`, `Slice<T>` |
| `exists...By` | ¿Hay al menos uno? | `boolean` |
| `count...By` | Cuántos hay | `long` |
| `delete...By` (o `remove`) | Borrar los que cumplan | `void` o `long` (requiere `@Transactional`) |

## 2. Modificadores antes del `By`

| Palabra | Para qué sirve |
|---|---|
| `Distinct` | Quita filas repetidas. Se usa cuando navegas colecciones y una entidad puede salir varias veces. |
| `Top5` / `First5` | Limita a los primeros N. `First` solo (sin número) equivale a 1. |

## 3. Criterios de filtrado

| Palabra | Significado | Ejemplo |
|---|---|---|
| (nada) / `Is` / `Equals` | Igual a | `findByName(n)` |
| `Not` / `IsNot` | Distinto de | `findByNameNot(n)` |
| `And` | Ambas condiciones | `findByNameAndCity(n, c)` |
| `Or` | Cualquiera de las dos | `findByNameOrCity(n, c)` |
| `In` | Está en una colección | `findByIdIn(Collection<Long> ids)` |
| `NotIn` | No está en la colección | `findByIdNotIn(ids)` |
| `True` / `False` | Booleano, sin parámetro | `findByActiveTrue()` |
| `IsNull` / `IsNotNull` | Es o no es null, sin parámetro | `findByEndDateIsNull()` |
| `LessThan` / `LessThanEqual` | `<` / `<=` | `findByCreditosLessThan(3)` |
| `GreaterThan` / `GreaterThanEqual` | `>` / `>=` | `findByCreditosGreaterThanEqual(3)` |
| `Between` | Rango inclusivo, recibe dos parámetros | `findByCreditosBetween(2, 4)` |
| `Before` / `After` | Antes o después de una fecha | `findByMatchDateAfter(fecha)` |
| `Containing` | Contiene el texto (agrega `%` por ti) | `findByNameContaining("mad")` |
| `StartingWith` | Empieza con | `findByNameStartingWith("Re")` |
| `EndingWith` | Termina con | `findByEmailEndingWith("@icesi.edu.co")` |
| `Like` / `NotLike` | Patrón SQL. **Tú pones los `%`.** | `findByNameLike("%mad%")` |
| `IsEmpty` / `IsNotEmpty` | Colección vacía o con elementos | `findByPlayerClubsIsEmpty()` |

## 4. Modificadores de texto y orden

| Palabra | Para qué sirve |
|---|---|
| `IgnoreCase` | Ignora mayúsculas en **ese** campo. Se pega al campo: `findByNameIgnoreCase(n)`. |
| `AllIgnoreCase` | Ignora mayúsculas en **todos** los campos de texto. Va al final de los criterios: `findByNameAndCityAllIgnoreCase(n, c)`. |
| `OrderBy` | Empieza la cláusula de orden. |
| `Asc` / `Desc` | Ascendente (por defecto) o descendente. |
| Varios campos | `OrderByApellidoAscNombreAsc`: primero apellido, luego nombre. |

## 5. Navegar relaciones

Se recorre el camino de atributos, separado con `_` (opcional pero más claro):

- `findByCountry_Name(n)` navega jugador → país → nombre.
- `findByPlayerClubs_Club_Name(n)` navega jugador → colección → club → nombre.
- Varios criterios sobre el mismo camino de colección **reutilizan el mismo join**. Así, `Club_Name` y `EndDateIsNull` se evalúan sobre la misma fila.

## 6. Parámetros especiales (al final de la firma)

| Parámetro | Para qué sirve |
|---|---|
| `Pageable` | Paginación y orden: `Page<Player> findByCountry_Name(String n, Pageable p)` |
| `Sort` | Orden dinámico sin paginar |
| `Limit` | Límite dinámico (alternativa a `Top5`) |

## 7. Tipos de retorno

| Tipo | Cuándo |
|---|---|
| `List<T>` | Cero o más resultados |
| `Optional<T>` | Cero o uno (si hay más de uno, lanza error) |
| `T` | Uno; devuelve `null` si no hay |
| `boolean` / `long` | Con `exists` / `count` |
| `Page<T>` | Con `Pageable`; incluye el total de páginas (hace un count extra) |
| `Slice<T>` | Con `Pageable`; solo sabe si hay página siguiente |

## Trampas frecuentes

- **`Distinct` con `OrderBy` sobre un campo de otra tabla** falla en H2 y PostgreSQL. Ordena por un campo de la propia entidad, o quita el `Distinct`.
- **`Top` con un join a colección** limita filas, no entidades. Si hay duplicados, puedes recibir menos de N distintas.
- **`Like` no agrega `%`**; `Containing`, `StartingWith` y `EndingWith` sí.
- **Los parámetros van en el orden en que aparecen los criterios.** `True`, `False`, `IsNull` e `IsNotNull` no piden parámetro; `Between` pide dos.
- **`And` y `Or` mezclados** se leen de izquierda a derecha sin paréntesis. Si necesitas agrupar, piensa dos veces o resuélvelo en dos pasos.
- **No hay agregaciones** (`max`, `sum`, `group by`). Un "máximo por grupo" se resuelve con un orden más un paso en Java.
- **Nombres de campos:** deben coincidir con los del Java (`birthDate`, no `birth_date`). Un error aquí hace que la app no arranque.