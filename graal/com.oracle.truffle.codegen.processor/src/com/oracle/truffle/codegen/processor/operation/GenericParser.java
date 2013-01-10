/*
 * Copyright (c) 2012, 2012, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.oracle.truffle.codegen.processor.operation;

import java.lang.annotation.*;

import javax.lang.model.element.*;

import com.oracle.truffle.api.codegen.*;
import com.oracle.truffle.codegen.processor.*;
import com.oracle.truffle.codegen.processor.template.*;
import com.oracle.truffle.codegen.processor.template.ParameterSpec.Cardinality;
import com.oracle.truffle.codegen.processor.template.ParameterSpec.Kind;

public class GenericParser extends OperationMethodParser<SpecializationData> {

    public GenericParser(ProcessorContext context, OperationData operation) {
        super(context, operation);
    }

    @Override
    public MethodSpec createSpecification(ExecutableElement method, AnnotationMirror mirror) {
        return createDefaultMethodSpec(null);
    }

    @Override
    protected ParameterSpec createValueParameterSpec(String valueName) {
        return new ParameterSpec(valueName, getOperation().getTypeSystem().getGenericType(), Kind.EXECUTE, false);
    }

    @Override
    protected ParameterSpec createReturnParameterSpec() {
        return new ParameterSpec("returnValue", getOperation().getTypeSystem(), Kind.EXECUTE, false, Cardinality.ONE);
    }

    @Override
    public SpecializationData create(TemplateMethod method) {
        return new SpecializationData(method, true, false);
    }

    @Override
    public Class< ? extends Annotation> getAnnotationType() {
        return Generic.class;
    }

}