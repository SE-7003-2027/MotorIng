# Guía de contribución

Gracias por contribuir a MotorIng  (˶>⩊<˶)

⠀⠀⠀⠀⢀⣤⠤⣄⠀⠀⠀⠀⣠⠤⣄⠀⠀⠀
⠀⠀⠀⢠⠞⠀⠀⠈⢷⠀⠀⡜⠃⠀⠈⢳⠀⠀
⠀⠀⠀⣾⠀⠀⠀⠀⠘⡇⢰⠅⠀⠀⠀⠸⡇⠀
⠀⠀⠀⣿⠀⠀⠀⠀⠀⡇⣾⠀⠀⠀⠀⢸⠃⠀
⠀⠀⠀⢹⡀⠀⠀⠀⠀⡇⣿⠀⠀⠀⠀⡾⠀⠀
⠀⠀⠀⠸⡇⠀⠀⠀⠀⠷⠿⠀⠀⠀⢰⠇⠀⠀
⠀⢀⡴⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢶⡀⠀
⢰⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡄
⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣷
⢹⠀⠀⠀⢰⡆⠀⠀⠀⠀⠀⠀⢀⣄⠀⠀⠀⡟
⠈⢧⡀⠀⠀⠀⠀⠀⢄⡀⣀⠀⠀⠁⠀⠀⣸⠃
⠀⠈⠻⢦⣀⠀⠀⠀⠚⠙⠂⠀⠀⠀⣀⡴⠋⠀
⠀⠀⠀⠀⠈⠉⠓⠒⠲⠶⠶⠒⠒⠋⠁⠀⠀⠀

## Flujo de trabajo

Antes de comenzar a implementar una funcionalidad:

1. Revisar los Issues disponibles.
2. Verificar si existe una tarea de investigación (SPIKE) relacionada.
3. Revisar los ADR correspondientes a las decisiones de arquitectura.
4. Crear o asignarse el Issue correspondiente.
5. Crear una rama para el trabajo.

### Ramas

Las ramas deben seguir el siguiente formato:

```text
feature/<descripcion>
fix/<descripcion>
refactor/<descripcion>
docs/<descripcion>
spike/<descripcion>
```

Ejemplos:

```text
feature/renderizado-opengl
fix/error-windowmanager
docs/documentar-main
```

## Commits

Los commits deben ser pequeños y claros.

Formato recomendado:

```text
tipo: descripcion 
```

o si puedes describir en especifico el archivo sobre el que se trabajo

```text
tipo(archivo): descripcion 
```

Tipos:

* `feat`: nueva funcionalidad
* `fix`: corrección de errores
* `refactor`: modificación del código sin cambiar su comportamiento
* `docs`: documentación
* `test`: pruebas
* `chore`: tareas de mantenimiento
* `spike`: investigación

Ejemplos:

```text
feat: agregar sistema de renderizado
fix(main): corregir inicializacion de ventana
docs(README): actualizar guia de instalacion
```

## Pull Requests

Todo cambio que vaya a integrarse a la rama principal debe realizarse mediante un Pull Request.

Antes de abrir un PR:

* Verificar que el código compile correctamente.
* Ejecutar las pruebas disponibles.
* Revisar que no existan errores de formato.
* Actualizar la documentación cuando sea necesario.
* Verificar que el cambio corresponda al Issue asociado.

### Título del PR

El título debe describir el cambio:

```text
feat: implementar renderizado básico
fix: corregir creación de ventana
docs: documentar API de renderizado
```

### Descripción del PR


* Qué se modificó.
* Por qué se realizó el cambio.
* Issue relacionado.
* Pruebas realizadas.
* Consideraciones importantes para revisar.

## Revisión de código

Los PR deben ser revisados por al menos otro integrante del equipo antes de integrarse a la rama principal.

se debe verificar:

* COdigo bien hecho
* Cumplir con la arquitectura
* Cumplir con el estilo
* Pruebas
* Documentación

## Arquitectura y ADR

Las decisiones importantes de arquitectura deben documentarse mediante ADRs.

Antes de introducir una tecnología, biblioteca o cambio arquitectónico importante, se debe investigar primero las alternativas disponibles y documentar la decisión.

Los ADR se encuentran en:

```text
/ADR
```

## SPIKEs

Las tareas de investigación deben registrarse como Issues de tipo SPIKE.

Un SPIKE debe responder una pregunta concreta antes de comenzar una implementación.

Ejemplos:

* ¿Qué biblioteca gráfica utilizaremos?
* ¿Qué APIs necesita exponer la biblioteca?
* ¿Qué plataformas soportaremos?
* ¿Qué lenguaje se adapta mejor al proyecto?

El resultado del SPIKE debe quedar documentado y, cuando corresponda, generar un ADR.

## Código

Todo código nuevo debe seguir la guía de estilo definida en:

```text
STYLE_GUIDE.md
```

Los cambios deben mantener la arquitectura y las interfaces públicas del proyecto.

⠀⠀⠀⠀ ⠀⠀⠀⣀⠤⠔⠒⠒⡄⢀⣠⠤⠤⠦⡄⠀
⠀⠀⠀⠀⠀⢀⡴⠋⠀⠀⠀⣀⠴⠊⣡⣴⣾⡿⣣⠃⠀⠀
⠀⠀⠀⠀⢰⠋⠀⠀⠀⡤⠊⠁⣠⣾⡿⠟⣉⠴⠁⠀⠀⠀
⠀⠀⠀⡠⠓⠀⠀⠀⠘⠁⢒⣿⠍⠓⠒⠉⠀⠀⠀⠀⠀⠀
⠀⢠⠞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠑⣄⠀⠀⠀⠀⠀⠀⠀⠀
⠀⡏⠀⠀⠀⠀⠴⠂⠀⠀⠀⠀⠀⠘⢦⠀⠀⠀⠀⠀⠀⠀
⢸⠘⠉⠀⠀⠀⣴⣶⢶⢀⠤⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀
⠀⢷⣿⣵⣴⡆⢙⠉⡘⠟⠉⠁⠀⢀⡼⠁⠀⠀⠀⠀⠀⠀
⢀⣾⡉⠣⠵⠶⠎⠉⠀⠀⠀⡠⠖⠛⠉⠉⠉⠙⢦⡀⠀⠀
⠀⠊⠑⠂⠀⠤⣄⠀⠀⠀⠀⠀⠀⢀⣠⠄⠒⠀⠘⠁⠀⠀
⣴⣒⠤⢤⡠⠔⡏⠀⠀⣀⠀⠀⠀⠀⠈⠙⠒⠢⢴⠑⢢⠀
⠷⡀⠁⠀⠀⠈⡏⠑⠊⠉⠀⠀⠀⠀⠀⠀⠀⠀⠈⡇⢠⠁
⠀⠈⠉⠉⠉⠉⠱⡀⠀⠀⠀⠀⠰⠀⠀⠀⠀⠀⠀⡏⠁⠀
⠀⠀⠀⠀⠀⠀⢸⠉⠒⠤⠤⢤⡇⠀⠀⠀⠀⢀⢼⣇⠀⠀
⠀⠀⠀⠀⠀⢠⠶⠿⠤⠤⠔⠛⡞⠦⣄⡠⡤⢊⣾⠟⠀⠀
⠀⠀⠀⠀⠀⢱⣤⣤⣤⠠⢶⡿⠀⠀⠀⠙⠶⠽⠟⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀