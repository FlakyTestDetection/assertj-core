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
package org.assertj.core.api.localtime;

import static org.assertj.core.api.AbstractLocalTimeAssert.NULL_LOCAL_TIME_PARAMETER_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.FailureMessages.actualIsNull;

import java.time.LocalTime;

import org.assertj.core.api.BaseTest;
import org.junit.Test;

public class LocalTimeAssert_hasSameHourAs_Test extends BaseTest {

  private final LocalTime refLocalTime = LocalTime.of(23, 0, 0, 0);

  @Test
  public void should_pass_if_actual_andexpected_have_same_hour() {
	assertThat(refLocalTime).hasSameHourAs(refLocalTime.plusMinutes(1));
  }

  @Test
  public void should_fail_if_actual_is_not_equal_to_given_localtimetime_with_minute_ignored() {
    thrown.expectAssertionError("%n" +
                                "Expecting:%n" +
                                "  <23:00>%n" +
                                "to have same hour as:%n" +
                                "  <22:59>%n" +
                                "but had not.");
    assertThat(refLocalTime).hasSameHourAs(refLocalTime.minusMinutes(1));
  }

  @Test
  public void should_fail_as_minutes_fields_are_different_even_if_time_difference_is_less_than_a_minute() {
    thrown.expectAssertionError("%n" +
                                "Expecting:%n" +
                                "  <23:00>%n" +
                                "to have same hour as:%n" +
                                "  <22:59:59.999999999>%n" +
                                "but had not.");
    assertThat(refLocalTime).hasSameHourAs(refLocalTime.minusNanos(1));
  }

  @Test
  public void should_fail_if_actual_is_null() {
	expectException(AssertionError.class, actualIsNull());
	LocalTime actual = null;
	assertThat(actual).hasSameHourAs(LocalTime.now());
  }

  @Test
  public void should_throw_error_if_given_localtimetime_is_null() {
	expectIllegalArgumentException(NULL_LOCAL_TIME_PARAMETER_MESSAGE);
	assertThat(refLocalTime).hasSameHourAs(null);
  }

}
