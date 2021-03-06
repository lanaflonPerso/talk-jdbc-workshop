/*
 * Copyright 2019 the original author or authors.
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
package workshop.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

/**
 * @author Jens Schauder
 */
@Table("UUID_ENTITY")
class UuidEntityPresetId implements Persistable {

	@Id
	UUID id;

	String name;

	@Transient
	boolean isNew;

	@PersistenceConstructor
	private UuidEntityPresetId(UUID id, String name) {
		this.id = id;
		this.name = name;
		this.isNew = false;
	}

	UuidEntityPresetId(String name) {
		id = UUID.randomUUID();
		this.name = name;
		this.isNew = true;
	}

	@Override
	public Object getId() {
		return id;
	}

	@Override
	public boolean isNew() {
		return isNew;
	}
}
