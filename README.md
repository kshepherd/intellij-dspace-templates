# intellij-dspace-templates
IntelliJ IDEA File and Code Templates for DSpace 7 projects

Templates use Apache Velocity (https://velocity.apache.org/engine/2.3/user-guide.html) with some reserved variable names (NAME, PACKAGE\_NAME, etc - see IDEA help for more info) and some that take user input.

Includes are simple static files that can be used as file headers, author attribution statements, etc.

## Importing
In IntelliJ IDEA with a DSpace 7 REST project open, go to Settings, File and Code Templates. I usually switch to Project schema as the templates are only relevant for DSpace backend code.

### Includes
Add a new include of the same name as the file in `includes/` and paste the contents into it. If includes here are renamed, the references in templates should also be renamed.

You might need or want to set extensions for these but it shouldn't matter.

### Templates
Add a new template and paste the contents of a `templates/code` or `templates/file` template into it. If you have one of the file templates open in IntelliJ IDEA, you should be able to use the "Create template from file" context action, too.

## Usage
Use file templates with the **New** context menu, in the appropriate location (eg. you should be creating a new file in a valid java source directory if you want to create a new java class).

Use code templates with things like **Code** -> **Surround With** or with Live Templates (Ctl-J, or surround with Ctl-Alt-J while highlighting some code)

If non-reserved variables are used in a template, you will be presented with a form to enter values at the time of adding the new file or code.

## Extending
See the following documentation for some tips:

* https://velocity.apache.org/engine/2.3/user-guide.html
* https://www.jetbrains.com/help/idea/generate-custom-code-constructs-using-live-templates.html#1c82d8ea
