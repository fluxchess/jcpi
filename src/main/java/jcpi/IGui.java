/*
** Copyright 2007-2012 Phokham Nonava
**
** Licensed under the Apache License, Version 2.0 (the "License");
** you may not use this file except in compliance with the License.
** You may obtain a copy of the License at
**
**     http://www.apache.org/licenses/LICENSE-2.0
**
** Unless required by applicable law or agreed to in writing, software
** distributed under the License is distributed on an "AS IS" BASIS,
** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
** See the License for the specific language governing permissions and
** limitations under the License.
*/
package jcpi;

import jcpi.commands.GuiBestMoveCommand;
import jcpi.commands.GuiInformationCommand;
import jcpi.commands.GuiInitializeAnswerCommand;
import jcpi.commands.GuiQuitCommand;
import jcpi.commands.GuiReadyAnswerCommand;

/**
 * This is the gui command interface.
 *
 * @author Phokham Nonava
 */
public interface IGui {

    void visit(GuiInitializeAnswerCommand command);
    void visit(GuiReadyAnswerCommand command);
    void visit(GuiBestMoveCommand command);
    void visit(GuiInformationCommand command);
    void visit(GuiQuitCommand command);

}
