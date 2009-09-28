/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.apache.mina.filter.executor;

import java.util.EventListener;

import org.apache.mina.core.session.IoEvent;

/**
 * Listens and filters all event queue operations occurring in
 * {@link OrderedThreadPoolExecutor} and {@link UnorderedThreadPoolExecutor}.
 *
 * @author The Apache MINA Project (dev@mina.apache.org)
 */
public interface IoEventQueueHandler extends EventListener {

    /**
     * A dummy handler which always accepts event doing nothing particular.
     */
    static IoEventQueueHandler NOOP = new IoEventQueueHandler() {
        public boolean accept(Object source, IoEvent event) {
            return true;
        }
        public void offered(Object source, IoEvent event) {
            // NOOP
        }
        public void polled(Object source, IoEvent event) {
            // NOOP
        }
    };

    /**
     * Returns <tt>true</tt> if and only if the specified <tt>event</tt> is
     * allowed to be offered to the event queue.  The <tt>event</tt> is dropped
     * if <tt>false</tt> is returned.
     */
    boolean accept(Object source, IoEvent event);

    /**
     * Invoked after the specified <tt>event</tt> has been offered to the
     * event queue.
     */
    void offered(Object source, IoEvent event);

    /**
     * Invoked after the specified <tt>event</tt> has been polled from the
     * event queue.
     */
    void polled(Object source, IoEvent event);
}
