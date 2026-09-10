# Style Guide

## Naming

* Classes use `PascalCase`.

* Functions use `camelCase`.

* Variables use `snake_case`.

* Constants use `UPPER_SNAKE_CASE`.

Example:

```cpp
class Renderer {

public:
	void initializeRenderer();
};

const int MAX_TEXTURES = 32;
```

## Formatting

* Use tabs for indentation (1 tab per level).

* Keep lines of code at a reasonable length.

* Place opening braces on the same line as the declaration.

* If something can be written as a one-liner, use braces to prevent errors.

Instead of:

```Java
if (x > 10) System.out.println("Yes");
```

Use:

```Java
if (x > 10){
	System.out.println("Greater");
}
```

## Comments

Simple comments are allowed, but there must be comments for documentation.

## Documentation

Documentation for classes, methods, and public attributes must use Javadoc/Doxygen according to the selected language.

## Functions

Functions must have a single responsibility.

Preferably, divide the logic into auxiliary functions as required.

## Errors

Do not ignore errors originating from external libraries or the system.

## Dependencies

Before adding a new library:

1. Research existing alternatives.

2. Evaluate licensing, compatibility, and maintenance.

3. Check compatibility with supported platforms.

4. Document important architectural decisions through an ADR.
