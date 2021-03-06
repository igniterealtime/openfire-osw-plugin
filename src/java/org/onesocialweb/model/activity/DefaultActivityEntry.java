/*
 *  Copyright 2010 Vodafone Group Services Ltd.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *    
 */
package org.onesocialweb.model.activity;

import java.util.ArrayList;
import java.util.List;

import org.onesocialweb.model.acl.AclRule;
import org.onesocialweb.model.atom.AtomReplyTo;
import org.onesocialweb.model.atom.DefaultAtomEntry;

public class DefaultActivityEntry extends DefaultAtomEntry implements ActivityEntry {
	
	private ActivityActor actor;
	
	private List<AclRule> rules = new ArrayList<AclRule>();
	
	private List<ActivityObject> objects = new ArrayList<ActivityObject>();
	
	private List<ActivityVerb> verbs = new ArrayList<ActivityVerb>();
		

	@Override
	public void addObject(ActivityObject object) {
		this.objects.add(object);
	}

	@Override
	public void addVerb(ActivityVerb verb) {
		this.verbs.add(verb);
	}

	@Override
	public void addAclRule(AclRule rule) {
		this.rules.add(rule);
	}
	
	@Override
	public List<AclRule> getAclRules() {
		return rules;
	}

	@Override
	public ActivityActor getActor() {
		return actor;
	}

	@Override
	public List<ActivityObject> getObjects() {
		return objects;
	}

	@Override
	public List<ActivityVerb> getVerbs() {
		return verbs;
	}
	
	@Override
	public void removeObject(ActivityObject object) {
		this.objects.remove(object);
	}
	
	@Override
	public void removeVerb(ActivityVerb verb) {
		this.verbs.remove(verb);
	}
	
	@Override
	public void removeAclRule(AclRule rule) {
		this.rules.remove(rule);
	}

	@Override
	public void setAclRules(List<AclRule> rules) {
		this.rules = rules;
	}

	@Override
	public void setActor(final ActivityActor actor) {
		this.actor = actor;
	}

	@Override
	public void setObjects(List<ActivityObject> objects) {
		this.objects = objects;
	}

	@Override
	public void setVerbs(final List<ActivityVerb> verbs) {
		this.verbs = verbs;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ActivityEntry ");
		buffer.append(super.toString());
		if (actor != null) {
			buffer.append("actor:" + actor + " ");
		}
		for (ActivityVerb verb : verbs) {
			buffer.append(verb.toString());
		}
		for (ActivityObject object : objects) {
			buffer.append(object.toString());
		}
		for (AclRule rule : rules) {
			buffer.append(rule.toString());
		}
		for (AtomReplyTo atomRecipient : getRecipients()) {
			buffer.append(atomRecipient.toString());
		}
		buffer.append("]");
		return buffer.toString();
	}

	@Override
	public boolean hasAclRules() {
		return (rules != null && rules.size() > 0);
	}

	@Override
	public boolean hasActor() {
		return (actor != null);
	}

	@Override
	public boolean hasObjects() {
		return (objects != null && objects.size() > 0);
	}

	@Override
	public boolean hasVerbs() {
		return (verbs != null && verbs.size() > 0);
	}
	
}
