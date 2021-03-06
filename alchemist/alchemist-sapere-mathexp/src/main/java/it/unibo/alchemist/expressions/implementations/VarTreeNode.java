/*
 * Copyright (C) 2010-2014, Danilo Pianini and contributors
 * listed in the project's pom.xml file.
 * 
 * This file is part of Alchemist, and is distributed under the terms of
 * the GNU General Public License, with a linking exception, as described
 * in the file LICENSE in the Alchemist distribution's top directory.
 */
package it.unibo.alchemist.expressions.implementations;

import java.util.Map;

import org.danilopianini.lang.util.FasterString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unibo.alchemist.expressions.interfaces.ITreeNode;


/**
 */
public class VarTreeNode extends ATreeNode<Object> {

    private static final long serialVersionUID = -2700393518024515482L;
    private static final Logger L = LoggerFactory.getLogger(VarTreeNode.class);

    /**
     * @param data
     *            variable name
     */
    public VarTreeNode(final FasterString data) {
        super(data, null, null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see alice.alchemist.expressions.interfaces.ITreeNode#getType()
     */
    @Override
    public Type getType() {
        return Type.VAR;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * alice.alchemist.expressions.implementations.ATreeNode#getValue(java.util
     * .Map)
     */
    @Override
    public ITreeNode<?> getValue(final Map<FasterString, ITreeNode<?>> matches) {
        final ITreeNode<?> res = matches.get(getData());
        if (res == null) {
            L.error("Uninstanced variable: " + getData());
        }
        return res;
    }

    @Override
    public String toString() {
        return getData().toString();
    }

}
