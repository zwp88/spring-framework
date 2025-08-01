/*
 * Copyright 2002-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.reactive.resource;

import reactor.core.publisher.Mono;

import org.springframework.core.io.Resource;

/**
 * A {@code VersionStrategy} that relies on a fixed version applied as a request
 * path prefix, for example, reduced SHA, version name, release date, etc.
 *
 * <p>This is useful for example when {@link ContentVersionStrategy} cannot be
 * used such as when using JavaScript module loaders which are in charge of
 * loading the JavaScript resources and need to know their relative paths.
 *
 * @author Rossen Stoyanchev
 * @author Brian Clozel
 * @since 5.0
 * @see VersionResourceResolver
 */
public class FixedVersionStrategy extends AbstractPrefixVersionStrategy {

	private final Mono<String> versionMono;


	/**
	 * Create a new FixedVersionStrategy with the given version string.
	 * @param version the fixed version string to use
	 */
	public FixedVersionStrategy(String version) {
		super(version);
		this.versionMono = Mono.just(version);
	}


	@Override
	public Mono<String> getResourceVersion(Resource resource) {
		return this.versionMono;
	}

}
