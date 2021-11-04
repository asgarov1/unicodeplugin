# Unicode Plugin for IntelliJ

## Usage
This plugin allows to easily replace all non-latin characters with unicode.
You can either:

- Select text, right mouse click and press `Unicodify` for all non-latin chars under selection to be unicoded
- Right click inside of file without selection and press `Unicodify` - will replace all the non-latin chars in the whole file
- Right click on the file in Project tab and press `Unicodify` - same as previous (will replace all non-latin chars in the whole file)

A shortcut `Ctrl + Alt + U` can be used as well.

## To build
Simply run `gradle build`

## To install into Intellj
- After running build command you will find the zip inside of `./build/distributions`.
- Go to File -> Settings -> Plugins -> Install from disk -> select the zip

Like with all plugins you will need to restart for plugin to become active 