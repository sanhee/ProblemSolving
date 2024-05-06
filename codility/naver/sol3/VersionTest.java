package com.codility;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import java.util.*;

public class VersionTest {

    @Test
    public void thrownIfNullVersionPassedToConstructor() {
        assertThatThrownBy(() -> new Version(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorVersionMustNotBeNull);
    }

    @Test
    public void thrownIllegalArgumentExceptionIfVersionDoesNotMatchRegex() {
        assertThatThrownBy(() -> new Version("8.0-INVALID_SNAPSHOT"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorVersionMustMatchPattern);
    }

    @Test
    public void notThrowExceptionForValidArguments(){
        List<String> validVersions = Arrays.asList(
                "1",
                "1.0",
                "1.0.0",
                "1-SNAPSHOT",
                "1.0-SNAPSHOT",
                "1.0.0-SNAPSHOT"
        );

        validVersions.forEach(versionName ->
                assertThatCode(() -> {
                    Version v = new Version(versionName);
                }).doesNotThrowAnyException()
        );
    }

    @Test
    public void isSnapshotShouldReturnTrueForSnapshotSuffix(){
        final String snapshotVersion = "1.0.0-SNAPSHOT";
        final Version version = new Version(snapshotVersion);

        assertThat(version.isSnapshot()).isTrue();
    }

    @Test
    public void isSnapshotShouldReturnFalseWithoutSnapshotSuffix(){
        final String nonSnapshotVersion = "1.0.0";
        final Version version = new Version(nonSnapshotVersion);

        assertThat(version.isSnapshot()).isFalse();
    }

    @Test
    public void thrownIfVersionCompareToNull() {
        final Version version = new Version("1.0.0-SNAPSHOT");

        assertThatThrownBy(() -> version.compareTo(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorOtherMustNotBeNull);
    }

    @Test
    public void snapshowVersionLessThanNonSnapshotSuffix(){
        final Version snapshotVersion = new Version("1.0.0-SNAPSHOT");
        final Version nonSnapshotVersion = new Version("1.0.0");

        assertThat(snapshotVersion.compareTo(nonSnapshotVersion)).isNegative();
        assertThat(nonSnapshotVersion.compareTo(snapshotVersion)).isPositive();
    }


    @Test
    public void versionsShouldBeComparedCorrectly(){
        final Version v1 = new Version("1.0.0");
        assertThat(v1.compareTo(new Version("1.0.0"))).isZero();
    }

    // expected error messages:

    static final String errorVersionMustNotBeNull = "'version' must not be null!";
    static final String errorOtherMustNotBeNull =  "'other' must not be null!";
    static final String errorVersionMustMatchPattern =  "'version' must match: 'major.minor.patch(-SNAPSHOT)'!";
}
