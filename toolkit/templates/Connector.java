/*
 * Copyright 2008 Sun Microsystems, Inc. All rights reserved.
 * 
 * U.S. Government Rights - Commercial software. Government users 
 * are subject to the Sun Microsystems, Inc. standard license agreement
 * and applicable provisions of the FAR and its supplements.
 * 
 * Use is subject to license terms.
 * 
 * This distribution may include materials developed by third parties.
 * Sun, Sun Microsystems, the Sun logo, Java and Project Identity 
 * Connectors are trademarks or registered trademarks of Sun 
 * Microsystems, Inc. or its subsidiaries in the U.S. and other
 * countries.
 * 
 * UNIX is a registered trademark in the U.S. and other countries,
 * exclusively licensed through X/Open Company, Ltd. 
 * 
 * -----------
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 2008 Sun Microsystems, Inc. All rights reserved. 
 * 
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License(CDDL) (the License).  You may not use this file
 * except in  compliance with the License. 
 * 
 * You can obtain a copy of the License at
 * http://identityconnectors.dev.java.net/CDDLv1.0.html
 * See the License for the specific language governing permissions and 
 * limitations under the License.  
 * 
 * When distributing the Covered Code, include this CDDL Header Notice in each
 * file and include the License file at identityconnectors/legal/license.txt.
 * If applicable, add the following below this CDDL Header, with the fields 
 * enclosed by brackets [] replaced by your own identifying information: 
 * "Portions Copyrighted [year] [name of copyright owner]"
 * -----------
 */
package <%= packageName %>;

import java.util.*;

import org.identityconnectors.common.security.*;
import org.identityconnectors.framework.spi.*;
import org.identityconnectors.framework.spi.operations.*;
import org.identityconnectors.framework.common.exceptions.*;
import org.identityconnectors.framework.common.objects.*;
import org.identityconnectors.framework.common.objects.filter.FilterTranslator;
import org.identityconnectors.common.StringUtil;
import org.identityconnectors.common.logging.Log;

/**
 * Main implementation of the $resourceName Connector
 * 
 * @author $userName
 * @version 1.0
 * @since 1.0
 */
@ConnectorClass(
    displayNameKey = "$resourceName",
    configurationClass = <%= resourceName %>Configuration.class)
public class <%= resourceName %>Connector implements PoolableConnector, <%= interfaces.join(", ") %>
{
    /**
     * Setup logging for the {@link <%= resourceName %>Connector}.
     */
    private static final Log log = Log.getLog(<%= resourceName %>Connector.class);

    /**
     * Place holder for the Connection created in the init method
     */
    private <%= resourceName %>Connection connection;

    /**
     * Place holder for the {@link Configuration} passed into the init() method
     * {@link <%= resourceName %>Connector#init}.
     */
    private <%= resourceName %>Configuration config;

    /**
     * Gets the Configuration context for this connector.
     */
    public Configuration getConfiguration() {
        return this.config;
    }

    /**
     * Callback method to receive the {@link Configuration}.
     * 
     * @see Connector#init
     */
    public void init(Configuration cfg) {
        this.config = (<%= resourceName %>Configuration) cfg;
        this.connection = new <%= resourceName %>Connection(this.config);
    }

    /**
     * Disposes of the {@link <%= resourceName %>Connector}'s resources.
     * 
     * @see Connector#dispose()
     */
    public void dispose() {
        config = null;
        if ( connection != null ) {
            connection.dispose();
            connection = null;
        }
    }

    public void checkAlive() {
        connection.test();
    }

    /******************
     * SPI Operations
     * 
     * Implement the following operations using the contract and
     * description found in the Javadoc for these methods.
     ******************/  
    <% if(interfaces.contains("AdvancedUpdateOp")) { %>
    /**
     * {@inheritDoc}
     */
    public Uid update(final AdvancedUpdateOp.Type type, final ObjectClass objClass, final Set<Attribute> attrs, final OperationOptions options) {
        throw new UnsupportedOperationException();
    } <% } %>
    
    <% if(interfaces.contains("AuthenticateOp")) { %>       
    /**
     * {@inheritDoc}
     */
    public void authenticate(final String username, final GuardedString password, final OperationOptions options) { 
       throw new UnsupportedOperationException();
    } <% } %>
    
    <% if(interfaces.contains("CreateOp")) { %>
    /**
     * {@inheritDoc}
     */
    public Uid create(final ObjectClass objClass, final Set<Attribute> attrs, final OperationOptions options) { 
        throw new UnsupportedOperationException();
    } <% } %>
       
    <% if(interfaces.contains("DeleteOp")) { %>
    /**
     * {@inheritDoc}
     */ 
    public void delete(final ObjectClass objClass, final Uid uid, final OperationOptions options) { 
        throw new UnsupportedOperationException();
    } <% } %>
    
    <% if(interfaces.contains("SchemaOp")) { %>
    /**
     * {@inheritDoc}
     */
    public Schema schema() {
        throw new UnsupportedOperationException();
    } <% } %>
    
    <% if(interfaces.contains("ScriptOnConnectorOp")) { %>
    /**
     * {@inheritDoc}
     */    
    public Object runScriptOnConnector(ScriptContext request, OperationOptions options) { 
        throw new UnsupportedOperationException();
    } <% } %>
    
    <% if(interfaces.contains("ScriptOnResourceOp")) { %>
    /**
     * {@inheritDoc}
     */     
    public Object runScriptOnResource(ScriptContext request, OperationOptions options) { 
        throw new UnsupportedOperationException();
    } <% } %>
    
    <% if(interfaces.contains("SearchOp<String>")) { %>
    /**
     * {@inheritDoc}
     */     
    public FilterTranslator<String> createFilterTranslator(ObjectClass objClass, OperationOptions options) { 
        throw new UnsupportedOperationException();
    }
    
    /**
     * {@inheritDoc}
     */
    public void executeQuery(ObjectClass objClass, String query, ResultsHandler handler, OperationOptions options) {
        throw new UnsupportedOperationException();
    } <% } %>
    
    <% if(interfaces.contains("SyncOp")) { %>
    /**
     * {@inheritDoc}
     */   
    public void sync(ObjectClass objClass, SyncToken token, SyncResultsHandler handler, final OperationOptions options) {
        throw new UnsupportedOperationException();
    } <% } %>
          
    <% if(interfaces.contains("TestOp")) { %>
    /**
     * {@inheritDoc}
     */   
    public void test() {
       throw new UnsupportedOperationException();
    } <% } %>
     
    <% if(interfaces.contains("UpdateOp")) { %>
    /**
     * {@inheritDoc}
     */ 
    public Uid update(final ObjectClass objclass, final Set<Attribute> attrs, final OperationOptions options) {
        throw new UnsupportedOperationException();
    } <% } %>     
}