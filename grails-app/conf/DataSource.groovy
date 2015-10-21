dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            driverClassName = "com.mysql.jdbc.Driver"
            dialect = "org.hibernate.dialect.MySQL5Dialect"
            username = "nuez"
            password = "nuez+1"
            dbCreate = "update"
            url = "jdbc:mysql://localhost:3306/nuez"
            pooled = true
            properties {
                maxActive = -1
                minEvictableIdleTimeMillis = 1800000
                timeBetweenEvictionRunsMillis = 1800000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "SELECT 1"
            }
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE"
        }
    }
    production {
        dataSource {
            driverClassName = "com.mysql.jdbc.Driver"
            dialect = "org.hibernate.dialect.MySQL5Dialect"
            username = "<username>"
            password = "<password>"
            dbCreate = "update"
            url = "jdbc:mysql://<ec2-hostname>:3306/nuez"
            pooled = true
            properties {
                maxActive = -1
                minEvictableIdleTimeMillis = 1800000
                timeBetweenEvictionRunsMillis = 1800000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "SELECT 1"
            }
        }
    }
    aws {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://${System.getProperty('RDS_HOSTNAME')}:${System.getProperty('RDS_PORT')}/nuez"
            driverClassName = "com.mysql.jdbc.Driver"
            username = System.getProperty('RDS_USERNAME')
            password = System.getProperty('RDS_PASSWORD')
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
    docker {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://${System.getenv()['MYSQL_PORT_3306_TCP_ADDR']}:${System.getenv()['MYSQL_PORT_3306_TCP_PORT']}/nuez"
            driverClassName = "com.mysql.jdbc.Driver"
            username = System.getenv()['MYSQL_ENV_MYSQL_USER']
            password = System.getenv()['MYSQL_ENV_MYSQL_PASSWORD']
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }

}