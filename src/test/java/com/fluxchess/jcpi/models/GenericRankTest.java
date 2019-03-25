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

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class GenericRankTest {

	@Test
	public void testValueOf() {
		assertThat(GenericRank.valueOf('1')).isEqualTo(GenericRank.R1);
	}

	@Test
	public void testInvalidValueOf() {
		Throwable thrown = catchThrowable(() -> GenericRank.valueOf('9'));
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void testIsValid() {
		assertThat(GenericRank.isValid('9')).isFalse();
	}

	@Test
	public void testPrev() {
		assertThat(GenericRank.R8.prev()).isEqualTo(GenericRank.R7);
		assertThat(GenericRank.R8.prev(7)).isEqualTo(GenericRank.R1);
	}

	@Test
	public void testIllegalPrev1() {
		Throwable thrown = catchThrowable(() -> GenericRank.R1.prev());
		assertThat(thrown).isInstanceOf(NoSuchElementException.class);
	}

	@Test
	public void testIllegalPrev2() {
		Throwable thrown = catchThrowable(() -> GenericRank.R7.prev(7));
		assertThat(thrown).isInstanceOf(NoSuchElementException.class);
	}

	@Test
	public void testHasPrev1() {
		assertThat(GenericRank.R1.hasPrev()).isFalse();
	}

	@Test
	public void testHasPrev2() {
		assertThat(GenericRank.R7.hasPrev(7)).isFalse();
	}

	@Test
	public void testNext() {
		assertThat(GenericRank.R1.next()).isEqualTo(GenericRank.R2);
		assertThat(GenericRank.R1.next(7)).isEqualTo(GenericRank.R8);
	}

	@Test
	public void testIllegalNext1() {
		Throwable thrown = catchThrowable(() -> GenericRank.R8.next());
		assertThat(thrown).isInstanceOf(NoSuchElementException.class);
	}

	@Test
	public void testIllegalNext2() {
		Throwable thrown = catchThrowable(() -> GenericRank.R2.next(7));
		assertThat(thrown).isInstanceOf(NoSuchElementException.class);
	}

	@Test
	public void testHasNext1() {
		assertThat(GenericRank.R8.hasNext()).isFalse();
	}

	@Test
	public void testHasNext2() {
		assertThat(GenericRank.R2.hasNext(7)).isFalse();
	}

	@Test
	public void testToChar() {
		assertThat(GenericRank.R1.toChar()).isEqualTo('1');
	}

	@Test
	public void testToString() {
		assertThat(GenericRank.R1.toString()).isEqualTo("1");
	}

}
