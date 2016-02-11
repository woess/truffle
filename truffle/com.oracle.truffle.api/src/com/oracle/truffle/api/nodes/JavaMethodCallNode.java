/*
 * Copyright (c) 2016, 2016, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
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
package com.oracle.truffle.api.nodes;

import java.lang.reflect.Method;

import com.oracle.truffle.api.TruffleRuntime;

/**
 * Represents a call to a Java {@link Method}, similar to {@link Method#invoke(Object, Object...)}.
 *
 * Please note: This class is not intended to be subclassed by guest language implementations.
 *
 * @see TruffleRuntime#createJavaMethodCallNode(Method)
 */
public abstract class JavaMethodCallNode extends Node {
    protected JavaMethodCallNode() {
    }

    /**
     * Invokes the Java method represented by this call node.
     *
     * @param obj the object the underlying method is invoked from or {@code null} if it is static.
     * @param arguments the arguments that should be passed to the method
     * @return the return result of the call
     * @throws Throwable if the underlying method throws an exception
     */
    public abstract Object invoke(Object obj, Object[] arguments) throws Throwable;
}
