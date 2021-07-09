/*
 * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
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

/*
 * @test
 * @bug 8269113
 * @summary Handling of switch (null)
 * @compile/fail/ref=SwitchNull2.out --enable-preview -source ${jdk.version} -XDrawDiagnostics SwitchNull2.java
 */
public class SwitchNull2 {

    void run() {
        switch (null) {
            case Object o: //no subtyping relation between null and Object, not a total pattern
        }
        switch (null) {
            case null: //no special case for null selectors, switch not complete
        }
    }

    void unreachable() {
        switch (null) {
            default: throw new AssertionError("Should not get here");
        }
        unreachable(); //unreachable statement
    }
}
