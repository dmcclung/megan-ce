/*
 *  Copyright (C) 2019 Daniel H. Huson
 *
 *  (Some files contain contributions from other authors, who are then mentioned separately.)
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package megan.chart.commands;

import jloda.swing.commands.CommandBase;
import jloda.swing.commands.ICheckBoxCommand;
import jloda.swing.util.ResourceManager;
import jloda.util.parse.NexusStreamParser;
import megan.chart.cluster.ClusteringTree;
import megan.chart.gui.ChartViewer;

import javax.swing.*;
import java.awt.event.ActionEvent;

class ClusterAttributesCommand extends CommandBase implements ICheckBoxCommand {
    public boolean isSelected() {
        final ChartViewer chartViewer = (ChartViewer) getViewer();
        return isApplicable() && chartViewer.getAttributesList().isDoClustering();
    }

    public String getSyntax() {
        return null;
    }

    public void apply(NexusStreamParser np) throws Exception {
    }

    public void actionPerformed(ActionEvent event) {
        execute("cluster what=attributes state=" + !isSelected() + ";");
    }

    public boolean isApplicable() {
        final ChartViewer chartViewer = (ChartViewer) getViewer();
        return chartViewer.getChartDrawer() != null && chartViewer.getChartDrawer().canCluster(ClusteringTree.TYPE.ATTRIBUTES);
    }

    public String getName() {
        return "Cluster Attributes";
    }

    public KeyStroke getAcceleratorKey() {
        return null;
    }

    public String getDescription() {
        return "Cluster attributes";
    }

    public ImageIcon getIcon() {
        return ResourceManager.getIcon("Cluster16.gif");
    }

    public boolean isCritical() {
        return true;
    }
}

