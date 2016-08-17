<h1>Installation</h1>
This plugin is available on the plugin repository at Jcenter, and may be installed
as described here:

https://plugins.gradle.org/plugin/com.needhamsoftware.solr-gradle

<h1> Configuration </h1>

The plugin comes pre-configured with defaults that look like this

    solr {
      zkHost '54.211.223.251'
      zkPort '9983'
      confName 'myConfig'
      confDir 'src/main/solr/myConfig'
    }

To change any of these, just add the above solr block with the properties you want to configure.
The `confDir` may be located anywhere your build can find it. The above is just an example.

<h1> Usage </h1>

To upload the files in the `confDir` to zookeeper simply run 

    gradle upconfig

To download the present configuration from zookeeper (and overwite exiting files in `confDir`!)

    gradle downconfig