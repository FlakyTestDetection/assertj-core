/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2018 the original author or authors.
 */
package org.assertj.core.api.abstract_;

import static org.assertj.core.test.ExpectedException.none;
import static org.assertj.core.api.Assertions.*;


import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.ConcreteAssert;
import org.assertj.core.test.ExpectedException;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for <code>{@link AbstractAssert#equals(Object)}</code> and <code>{@link AbstractAssert#hashCode()}</code>.
 * 
 * @author Nicolas François
 */
public class AbstractAssert_equal_hashCode_Test {

  @Rule
  public ExpectedException thrown = none();

  private ConcreteAssert assertions = new ConcreteAssert("myString");

  @Test
  @SuppressWarnings("deprecation")
  public void should_fail_because_not_supported_operation() {
    thrown.expectUnsupportedOperationException("'equals' is not supported...maybe you intended to call 'isEqualTo'");
    assertions.equals("anotherString");
  }

  @Test
  @SuppressWarnings("deprecation")
  public void should_not_fail_when_equals_exceptions_is_deactivated() {
    AbstractAssert.throwUnsupportedExceptionOnEquals = false;
    assertions.equals("anotherString");
  }


  @Test
  public void shouldReturnOneAsHashCode() {
    assertThat(assertions.hashCode()).isEqualTo(1);
  }

}
