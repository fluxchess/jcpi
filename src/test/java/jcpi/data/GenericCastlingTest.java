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
package jcpi.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class GenericCastlingTest {

    @Test
    public final void testValueOf() {
        assertEquals(GenericCastling.KINGSIDE, GenericCastling.valueOf('k'));
        assertEquals(GenericCastling.KINGSIDE, GenericCastling.valueOf('K'));
        assertNull(GenericCastling.valueOf('a'));
    }

    @Test
    public final void testValueOfLongToken() {
        assertEquals(GenericCastling.KINGSIDE, GenericCastling.valueOfLongToken("o-o"));
        assertEquals(GenericCastling.KINGSIDE, GenericCastling.valueOfLongToken("O-O"));
        assertNull(GenericCastling.valueOfLongToken("x-x"));
    }

    @Test
    public final void testToLongToken() {
        assertEquals("O-O", GenericCastling.KINGSIDE.toLongToken());
    }

    @Test
    public final void testToChar() {
        assertEquals('k', GenericCastling.KINGSIDE.toChar(GenericColor.BLACK));
    }

}
