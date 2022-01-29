package com.deguzman.DeGuzmanStuffAnywhere.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtil {

	/**
	 * Model Mapper Util tool to convert Java entity classes to Java DTO classes
	 * 
	 * helps limit information shown in the endpoints
	 * 
	 * @return
	 */
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

		return modelMapper;

	}
}
