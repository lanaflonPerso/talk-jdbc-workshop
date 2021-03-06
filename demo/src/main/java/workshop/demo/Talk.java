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

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jens Schauder
 */
@ToString
@EqualsAndHashCode
class Talk {

	@Id
	Long id;
	String title;
	List<Long> speakerIds = new ArrayList<>();

	Talk(String title) {
		this.title = title;
	}

	void addSpeakers(Speaker... speakers) {

		for (Speaker speaker : speakers) {
			addSpeaker(speaker);
		}
	}

	private void addSpeaker(Speaker speaker) {

		assert speaker != null;
		assert speaker.id != null;

		speakerIds.add(speaker.id);
	}
}
