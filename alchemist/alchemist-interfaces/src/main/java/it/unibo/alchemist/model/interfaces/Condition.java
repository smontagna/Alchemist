/*
 * Copyright (C) 2010-2014, Danilo Pianini and contributors
 * listed in the project's pom.xml file.
 * 
 * This file is part of Alchemist, and is distributed under the terms of
 * the GNU General Public License, with a linking exception, as described
 * in the file LICENSE in the Alchemist distribution's top directory.
 */
package it.unibo.alchemist.model.interfaces;

import java.io.Serializable;
import java.util.List;

/**
 * @param <T>
 *            The type which describes the concentration of a molecule
 * 
 *            Interface of a condition. Every condition must implement this
 *            interface.
 * 
 */
public interface Condition<T> extends Serializable {

    /**
     * This method allows to clone this action on a new node. It may result
     * useful to support runtime creation of nodes with the same reaction
     * programming, e.g. for morphogenesis.
     * 
     * @param n
     *            The node where to clone this {@link Condition}
     * @return the cloned action
     */
    Condition<T> cloneOnNewNode(Node<T> n);

    /**
     * @return The context for this condition.
     */
    Context getContext();

    /**
     * @return The list of molecules whose concentration may influence the truth
     *         value of this condition
     */
    List<? extends Molecule> getInfluencingMolecules();

    /**
     * @return the node this Condition belongs to
     */
    Node<T> getNode();

    /**
     * This method is a support for the propensity calculation inside the
     * Reactions. It allows this condition to influence the rate calculation in
     * some way. It's up to the reaction to decide whether to use or not this
     * information, and how.
     * 
     * @return how this condition may influence the propensity.
     */
    double getPropensityConditioning();

    /**
     * @return true if the condition is satisfied in current environment.
     */
    boolean isValid();

}
