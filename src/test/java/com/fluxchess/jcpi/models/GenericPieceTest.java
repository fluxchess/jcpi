/*
 * Copyright 2007-2019 The Java Chess Protocol Interface Project Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fluxchess.jcpi.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GenericPieceTest {

  @Test
  public void testValueOf() {
    assertEquals(GenericPiece.WHITEPAWN, GenericPiece.valueOf(GenericColor.WHITE, GenericChessman.PAWN));
    assertEquals(GenericPiece.WHITEPAWN, GenericPiece.valueOf('P'));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidValueOf() {
    GenericPiece.valueOf('x');
  }

  @Test
  public void testIsValid() {
    assertFalse(GenericPiece.isValid('x'));
  }

  @Test
  public void testToChar() {
    assertEquals('q', GenericPiece.BLACKQUEEN.toChar());
  }

}
