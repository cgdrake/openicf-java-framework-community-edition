/*
 * ====================
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2008-2009 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License("CDDL") (the "License").  You may not use this file
 * except in compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://opensource.org/licenses/cddl1.php
 * See the License for the specific language governing permissions and limitations
 * under the License.
 *
 * When distributing the Covered Code, include this CDDL Header Notice in each file
 * and include the License file at http://opensource.org/licenses/cddl1.php.
 * If applicable, add the following below this CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 * ====================
 */
package org.identityconnectors.framework.impl.serializer;

public class EnumSerializationHandler extends AbstractObjectSerializationHandler {

    public EnumSerializationHandler(Class<? extends Enum<?>> clazz, String name) {
        super(clazz, name);
    }

    public Object deserialize(final ObjectDecoder decoder) {
        String val = decoder.readStringField("value", null);
        @SuppressWarnings("unchecked")
        Class enumClass = (Class) getHandledObjectType();
        @SuppressWarnings("unchecked")
        Object rv = Enum.valueOf(enumClass, val);
        return rv;
    }

    public void serialize(final Object object, final ObjectEncoder encoder) {
        Enum<?> e = (Enum<?>) object;
        encoder.writeStringField("value", e.name());
    }

}
