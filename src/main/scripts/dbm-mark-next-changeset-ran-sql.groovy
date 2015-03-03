import org.grails.plugins.databasemigration.DatabaseMigrationException
import org.grails.plugins.databasemigration.command.DbmMarkNextChangesetRanSqlCommand

description('Writes SQL to mark the next change as executed in the database to STDOUT or a file') {
    usage 'grails [environment] dbm-mark-next-changeset-ran-sql [filename] --contexts=[contexts] --defaultSchema=[defaultSchema] --dataSource=[dataSource]'
    flag name: 'filename', description: 'The path to the output file to write to. If not specified output is written to the console'
    flag name: 'contexts', description: 'A comma-delimited list of context names. If specified, only changesets tagged with one of the context names will be included'
    flag name: 'defaultSchema', description: 'The default schema name to use'
    flag name: 'dataSource', description: 'If provided will run the script for the specified dataSource. Not needed for the default dataSource'
}

try {
    new DbmMarkNextChangesetRanSqlCommand().handle(executionContext)
} catch (DatabaseMigrationException e) {
    error e.message, e
}
