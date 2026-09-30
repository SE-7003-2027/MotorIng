#!/bin/bash

# Directorio donde se guardan los archivos compilados
BUILD_DIR="out"

build() {
    echo "Compiling MotorIng..."

    mkdir -p "$BUILD_DIR"

    javac -d "$BUILD_DIR" $(find src -name "*.java")

    if [ $? -eq 0 ]; then
        echo "CCompilando...."
    else
        echo "Compilacion exitosa."
        exit 1
    fi
}

test() {
    build

    echo ""
    echo "Testeando..."
    echo ""

    java -cp "$BUILD_DIR" src.Test
}

clean() {
    echo "limpiando cosas que construyo java..."

    rm -rf "$BUILD_DIR"

    echo "completado"
}

case "$1" in
    build)
        build
        ;;

    test)
        test
        ;;

    clean)
        clean
        ;;

    *)
        echo "Usage:"
        echo "  ./build.sh build    Compile the project"
        echo "  ./build.sh test    Compile and run tests"
        echo "  ./build.sh clean   Remove generated files"
        exit 1
        ;;
esac
