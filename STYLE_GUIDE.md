# Guía de estilo

## Nombres

* Las clases utilizan `PascalCase`.
* Las funciones utilizan `snake_case`.
* Las variables utilizan `snake_case`.
* Las constantes utilizan `UPPER_SNAKE_CASE`.

Ejemplo:

```cpp
class Renderer {
public:
    void initialize_renderer();
};

const int MAX_TEXTURES = 32;
```

## Formato


* utilizar tabs para la identacion, (1 tab por nivel).
* Mantener líneas de código con una longitud razonable.
* Colocar llaves de apertura en la misma línea que la declaración.
* Si se puede hacer un oneliner ponerlo con llaves para evitar errores 

en lugar de
```text
    if (x > 10) System.out.println("Si");
```

poner

```text
if (x > 10){
    System.out.println("Mayor");
}
```

## Comentarios

Puede haber comentarios simples, pero debe haber comentarios para documentacion

## Documentacion

La documentación de clases, métodos y atributos públicos
debe utilizar Javadoc/Doxygen según el lenguaje seleccionado.


## Funciones

Las funciones deben tener una unica responsabilidad

preferiblemente dividir la lógica en funciones auxiliares segun se requiera

## Errores


No ignorar  errores provenientes de bibliotecas externas o del sistema.

## Dependencias

Antes de agregar una nueva biblioteca:

1. Investigar las alternativas existentes.
2. Evaluar licencia, compatibilidad y mantenimiento.
3. Revisar compatibilidad con las plataformas soportadas.
4. Documentar decisiones arquitectónicas importantes mediante un ADR.
