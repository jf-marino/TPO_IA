# TPO_IA
TPO Inteligencia Artificial UADE 2015

## Bajarse el proyecto

Si tienen git instalado pueden hacer `git clone <url_del_repo>`
Sino hay un boton a la derecha que les deja bajar el .zip

## Dependencias

El JDK, como ya dije, no estoy seguro si necesitan la version 8 o no pero por las dudas no viene mal tenerlo.
En Windows hay una aplicacion de terminal copada que se llama [Chocolatey](https://chocolatey.org) que hace lo mismo que `apt-get` en Linux o `brew` en MAC. Si quieren usar eso pueden instalarlo y mandarle

```
choco install jdk8
```

### CLIPS

En la carpeta `lib` estan las dos dll (32 y 64 bits), ponganlas en `C:/Windows/system32/`

> Ojo! la dll que usen la tienen que copiar al system32 y renombrarla a CLIPSJNI.dll

Despues esta el .jar en la misma carpeta eso es lo mismo de siempre, van al build path y agregar JAR y listo

## Y listo :D

En teoria con eso les deberia andar, igual cualquier cosa lo vemos si no lo pueden correr. Java siempre trae problemas con los classpath y toda esa bola.

Nos vemos.
