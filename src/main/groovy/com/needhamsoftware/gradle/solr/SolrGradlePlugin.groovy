/*
 * Copyright 2016 Needham Software LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
    project.extensions.create('solr', SolrGradleExtension)

    //// UPCONFIG ////
    
    //noinspection GroovyAssignabilityCheck
    project.task('upconfig', {group 'solr'}) << {
      ZkCLI.main('-zkhost', project.solr.zkHost, '-cmd',
          'upconfig', '-confname', project.solr.confName, '-confdir', project.file(project.solr.confDir).toString() )
    }

    //// DOWNCONFIG ////

    //noinspection GroovyAssignabilityCheck
    project.task('downconfig', {group 'solr'}) << {
      ZkCLI.main('-zkhost', project.solr.zkHost, '-cmd',
          'downconfig', '-confname', project.solr.confName, '-confdir', project.file(project.solr.confDir).toString() )
    }
    
  }
}

class SolrGradleExtension {
  def String zkHost = 'localhost:9983'
  def String confName = 'myConfig'
  def String confDir = 'src/main/solr/myConfig'
}