/*
 * Copyright 2015 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.grails.plugins.databasemigration.liquibase.log

import grails.build.logging.GrailsConsole
import groovy.transform.CompileStatic
import liquibase.logging.LogLevel
import liquibase.logging.core.DefaultLogger
import liquibase.util.StringUtils

import java.text.DateFormat

@CompileStatic
class GrailsConsoleLogger extends DefaultLogger {

    final int priority = 5

    String name

    GrailsConsole console = GrailsConsole.instance

    protected void print(LogLevel logLevel, String message) {
        if (StringUtils.trimToNull(message) == null) {
            return
        }

        console.log("${logLevel} ${DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date())}: ${name}: ${buildMessage(message)}")
    }
}
