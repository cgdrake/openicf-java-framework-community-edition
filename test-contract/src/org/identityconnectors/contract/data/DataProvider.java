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
package org.identityconnectors.contract.data;

/**
 * DataProvider is a facility used for getting (reading/generating) data for
 * Contract test suite.
 * 
 * @author Dan Vernon
 */
public interface DataProvider {
    
    /**
     * Exception thwron when the value for some type cannot be resolved
     */
    @SuppressWarnings("serial")
    public class ObjectNotFoundException extends Exception {
        private String _searchedObjectName;
        
        public ObjectNotFoundException() {
            super();
        }

        public ObjectNotFoundException(String message) {
            super(message);
        }

        public ObjectNotFoundException(Throwable t) {
            super(t);
        }

        public ObjectNotFoundException(String message, Throwable t) {
            super(message, t);
        }

        public String getSearchedObjectName() {
            return _searchedObjectName;
        }

        public void setSearchedObjectName(String searchedObjectName) {
            _searchedObjectName = searchedObjectName;
        }                
    }

    /**
     * Gets data value by the specified parameters
     * 
     * @param dataTypeName
     * @param name
     * @param componentName
     * @param sequenceNumber
     * @return 
     * @throws org.identityconnectors.contract.data.DataProvider.ObjectNotFoundException
     */
    public Object get(String dataTypeName, String name,
            String componentName, int sequenceNumber) throws ObjectNotFoundException;
    
    /**
     * Gets data value by the specified parameters
     * 
     * @param dataTypeName
     * @param name
     * @param componentName
     * @return
     * @throws org.identityconnectors.contract.data.DataProvider.ObjectNotFoundException
     */
    public Object get(String dataTypeName, String name,
            String componentName) throws ObjectNotFoundException;

    /**
     * Gets data value by the specified parameters
     * 
     * @param name
     * @param componentName
     * @param sequenceNumber
     * @return
     * @throws org.identityconnectors.contract.data.DataProvider.ObjectNotFoundException
     */
    public String getString(String name,
            String componentName, int sequenceNumber) throws ObjectNotFoundException;
    
    /**
     * Gets data value by the specified parameters
     * 
     * @param name
     * @param componentName
     * @return
     * @throws org.identityconnectors.contract.data.DataProvider.ObjectNotFoundException
     */
    public String getString(String name,
            String componentName) throws ObjectNotFoundException;
    
    /**
     * Gets data value by the specified parameters
     * 
     * @param typeName
     * @param propName
     * @return
     * @throws org.identityconnectors.contract.data.DataProvider.ObjectNotFoundException
     */
    public Object getConnectorAttribute(String typeName, 
            String propName) throws ObjectNotFoundException;
    
    /**
     * Gets test suite attribute
     * 
     * @param typeName
     * @param propName
     * @return
     * @throws org.identityconnectors.contract.data.DataProvider.ObjectNotFoundException
     */
    public Object getTestSuiteAttribute(String typeName, 
            String propName) throws ObjectNotFoundException;
}