package org.tarent.cvio.server.common;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.tarent.cvio.server.auth.CVLdapAuthConf;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.authenticator.LdapConfiguration;
import com.yammer.dropwizard.config.Configuration;

/**
 * This is the application configuration for cvio. It is automatically created
 * and filled by dropwizard, reading the configuration file supplied at startup.
 * 
 * @author smancke
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CVIOConfiguration extends Configuration {

    /**
     * The path to the database folder.
     */
    @NotEmpty
    @JsonProperty
    private String dataDirectory;

    /**
     * The prefix to use in rest uris. Does not contain a trailing '/'.
     */
    @NotEmpty
    @JsonProperty
    private String uriPrefix;

    /**
     * To which address should eslasticsearch bind, if http is enabled (e.g.
     * 127.0.0.1, 0.0.0.0)?
     */
    @NotEmpty
    @JsonProperty
    private String elasticsearchBindHost;

    /**
     * Should the embedded elasticseach open an http port?
     */
    @NotEmpty
    @JsonProperty
    private String elasticsearchEnableHttp;

    /**
     * Default size for search operations within the Elasticsearch.
     */
    @NotNull
    @JsonProperty
    private int defaultEsFetchSize;

    /**
     * Path to the folder of the database.
     * 
     * @return the path
     */
    public String getDataDirectory() {
        return dataDirectory;
    }

    /**
     * The prefix to use in rest uris. Does not contain a trailing '/'.
     * 
     * @return the uri prefix
     */
    public String getUriPrefix() {
        return uriPrefix;
    }

    /**
     * to which addess should eslasticsearch bind, if http is enabled (default
     * is 127.0.0.1, 0.0.0.0)?
     * 
     * @return the address to bind
     */
    public String getElasticsearchBindHost() {
        if (elasticsearchBindHost == null) {
            return "127.0.0.1";
        }

        return elasticsearchBindHost;
    }

    /**
     * Should the embedded elasticseach open an http port?
     * 
     * @return true or false
     */
    public boolean isElasticsearchEnableHttp() {
        return Boolean.parseBoolean(elasticsearchEnableHttp);
    }

    /**
     * Default size for search operations within the Elasticsearch.
     * 
     * @return the default fetch size
     */
    public int getDefaultEsFetchSize() {
        return defaultEsFetchSize;
    }
    
    
    @Valid
    @NotNull
    private CVLdapAuthConf ldap = new CVLdapAuthConf();

    @JsonProperty("ldapconf")
    public CVLdapAuthConf getLdapConf() {        
     return ldap;     
    }
}
