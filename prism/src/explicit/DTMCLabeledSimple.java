//==============================================================================
//	
//	Copyright (c) 2002-
//	Authors:
//	* Dave Parker <david.parker@comlab.ox.ac.uk> (University of Oxford)
//	
//------------------------------------------------------------------------------
//	
//	This file is part of PRISM.
//	
//	PRISM is free software; you can redistribute it and/or modify
//	it under the terms of the GNU General Public License as published by
//	the Free Software Foundation; either version 2 of the License, or
//	(at your option) any later version.
//	
//	PRISM is distributed in the hope that it will be useful,
//	but WITHOUT ANY WARRANTY; without even the implied warranty of
//	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//	GNU General Public License for more details.
//	
//	You should have received a copy of the GNU General Public License
//	along with PRISM; if not, write to the Free Software Foundation,
//	Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//	
//==============================================================================

package explicit;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

import prism.PrismException;
import explicit.DTMCSimple;

/**
 * Simple explicit-state representation of a DTMC.
 */
public class DTMCLabeledSimple extends DTMCSimple
{
	protected Map<String,BitSet> labelToStates;

	// Constructors

	/**
	 * Constructor: empty DTMC.
	 */
	public DTMCLabeledSimple(Map<String,BitSet> labelToStates)
	{
		super();
		labelToStates = labelToStates;
	}

	/**
	 * Constructor: new DTMC with fixed number of states.
	 */
	public DTMCLabeledSimple(int numStates, Map<String,BitSet> labelToStates)
	{
		super(numStates);
		labelToStates = labelToStates;
	}

	/**
	 * Constructor: new DMTC from (square) transition matrix.
	 */
	public DTMCLabeledSimple(List<List<Double>> transitionMatrix, Map<String,BitSet> labelToStates) throws PrismException
	{
		super(transitionMatrix);
		labelToStates = labelToStates;
	}

	/**
	 * Copy constructor.
	 */
	public DTMCLabeledSimple(DTMCLabeledSimple dtmc, Map<String,BitSet> labelToStates)
	{
		super(dtmc);
		labelToStates = labelToStates;
	}

	/**
	 * Construct a DTMC from an existing one and a state index permutation,
	 * i.e. in which state index i becomes index permut[i].
	 * Pointer to states list is NOT copied (since now wrong).
	 * Note: have to build new Distributions from scratch anyway to do this,
	 * so may as well provide this functionality as a constructor.
	 */
	public DTMCLabeledSimple(DTMCLabeledSimple dtmc, int permut[], Map<String,BitSet> labelToStates)
	{
		super(dtmc);
		labelToStates = labelToStates;
	}

	// Mutators (for ModelSimple)
	@Override
	public Set<String> getLabels()
	{
		return labelToStates.keySet();
	}

	@Override
	public BitSet getLabelStates(String label)
	{
		return labelToStates.get(label);
	}

	@Override
	public Map<String,BitSet> getLabelToStatesMap()
	{
		return labelToStates;
	}

	@Override
	public boolean hasLabel(String label)
	{
		for (String key : labelToStates.keySet()) {
			if (key.equals(label)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void addLabel(String name, BitSet states) {
		// TODO
	}
}

