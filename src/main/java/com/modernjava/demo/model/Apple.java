package com.modernjava.demo.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Apple {

	public static final Double HEAVY_APPLE = 182.0;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.STRING)
	private AppleColor color;

	private Double weight;

	public Apple(AppleColor color, double weight) {
		this.color = color;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return String.format("Apple{color='%s', weight=%.2f}",
			color, weight);
	}
}
