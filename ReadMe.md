Camel Addon IDEA bug
====================

To reproduce the issue open this project in IDEA 15. 

Install JBoss Forge in IDEA.

Install the Camel addon

    http://fabric8.io/guide/forge.html

Its the camel addon (not the commands), eg

    addon-install --coordinate io.fabric8.forge:camel,2.2.72

 In the project activate forge cmd + alt 4
 
 Select the camel-add-endpoint-xml command

 In the UI select `netty4-http` as the component, you can filter by `http` to limit the choices, but its often easier to type `n` in the name box to jump down to `n`

 Enter the mandatory fields in the screen, and as well in the following steps, click next until you hit the error with the `Index out of bounds 2:2`

 The problem is tracked with:

    https://github.com/fabric8io/fabric8/issues/5374
    https://issues.jboss.org/browse/FORGE-2548

       