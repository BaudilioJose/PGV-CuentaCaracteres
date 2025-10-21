# PGV-CuentaCaracteres

## Descripción
Este proyecto implementa una aplicación multiproceso en Java para contar el número de líneas y palabras en el fichero "Citas_R&J.txt" (citas de Romeo y Julieta). Cumple con los criterios de programación paralela: el proceso principal cuenta líneas y lanza subprocesos por cada una para contar palabras, sincroniza resultados, muestra datos por línea y totales, y elimina archivos temporales.

## Requisitos

- Fichero "Citas_R&J.txt" en la carpeta `data/`.


## Uso
Ejecuta el programa principal: `java -cp src Lanzador`

**Salida esperada:**

- Datos de subprocesos.
- Palabras por línea.
- Total de líneas y palabras.
- Archivos temporales eliminados.

## Estructura del Proyecto

- `src/App.java`: Cuenta palabras de una cadena (paso a).
- `src/Lanzador.java`: Proceso principal que lee fichero, lanza subprocesos, sincroniza, muestra resultados y elimina archivos (pasos b-f).
- `data/Citas_R&J.txt`: Fichero de entrada.
- Archivos temporales: `output_linea_X.txt` (generados y eliminados automáticamente).

## Ramas

- `feature/contador-palabras`: Paso a.
- `feature/iniciar-proceso`: Paso b.
- `feature/leer-lineas-subprocesos`: Paso c.
- `feature/mostrar-resultados`: Paso d.
- `feature/esperar-subprocesos`: Paso e.
- `feature/eliminar-archivos`: Paso f.

Todas mergeadas a `main` al finalizar la rama development.

## Depuración y Notas

- Manejo de excepciones para IO y procesos.
- Sincronización con `waitFor()`.
