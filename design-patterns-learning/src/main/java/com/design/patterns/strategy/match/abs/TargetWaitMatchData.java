package com.design.patterns.strategy.match.abs;


import com.design.patterns.strategy.match.model.AnonymousFeature;
import com.design.patterns.strategy.match.model.Resume;

import java.util.List;

public interface TargetWaitMatchData {
	List<Resume> getTargetWaitMatchDate(AnonymousFeature anonymousFeature);
}
