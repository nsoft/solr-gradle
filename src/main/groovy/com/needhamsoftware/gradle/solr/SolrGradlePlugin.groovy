package com.needhamsoftware.gradle.solr

import org.apache.solr.cloud.ZkCLI
import org.gradle.api.Plugin
import org.gradle.api.Project;

/*
 * Created with IntelliJ IDEA.
 * User: gus
 * Date: 8/17/16
 */

class SolrGradlePlugin implements Plugin<Project> {
  void apply(Project project) {
    // Add the 'greeting' extension object
    project.extensions.create('solr', SolrGradleExtension)
    // Add a task that uses the configuration
    //noinspection GroovyAssignabilityCheck
    project.task('upconfig', {group 'solr'}) << {
      ZkCLI.main('-zkhost', project.solr.zkHost+':'+project.solr.zkPort, '-cmd',
          'upconfig', '-confname', project.solr.confName, '-confdir', project.file(project.solr.confDir).toString() )
    }
    //noinspection GroovyAssignabilityCheck
    project.task('downconfig', {group 'solr'}) << {
      ZkCLI.main('-zkhost', project.solr.zkHost+':'+project.solr.zkPort, '-cmd',
          'downconfig', '-confname', project.solr.confName, '-confdir', project.file(project.solr.confDir).toString() )
    }
  }
}

class SolrGradleExtension {
  def String zkHost = 'localhost'
  def String zkPort = '9983'
  def String confName = 'myConfig'
  def String confDir = 'src/main/solr/myConfig'
}