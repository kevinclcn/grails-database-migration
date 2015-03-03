import org.grails.plugins.databasemigration.DatabaseMigrationException
import org.grails.plugins.databasemigration.command.DbmUpdateCountCommand

description('Partially updates a database') {
    usage 'grails [environment] dbm-update-count [number] --contexts=[contexts] --defaultSchema=[defaultSchema] --dataSource=[dataSource]'
    flag name: 'number', description: 'The number of un-run changesets to run'
    flag name: 'contexts', description: 'A comma-delimited list of context names. If specified, only changesets tagged with one of the context names will be included'
    flag name: 'defaultSchema', description: 'The default schema name to use'
    flag name: 'dataSource', description: 'If provided will run the script for the specified dataSource. Not needed for the default dataSource'
}

try {
    new DbmUpdateCountCommand().handle(executionContext)
} catch (DatabaseMigrationException e) {
    error e.message, e
}
