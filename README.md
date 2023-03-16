# Unicode Plugin for IntelliJ

## Usage
This plugin allows to easily replace all non-latin characters with unicode.
You can either:

- Select text, right mouse click and press `Unicodify` for all non-latin chars under selection to be unicoded
- Select text, right mouse click and press `Decodify` for all unicode chars under selection to be decoded into text

There is also an option `Unicodify All` in order to unicodify all selected characters

Shortcut `Ctrl + Alt + U` / `Ctrl + Alt + D` can be used as well.

## To build
Simply run `gradle build`

## To install into Intellj
- After running build command you will find the zip inside of `./build/distributions`.
- Go to File -> Settings -> Plugins -> Install from disk -> select the zip

Like with all plugins you will need to restart for plugin to become active 