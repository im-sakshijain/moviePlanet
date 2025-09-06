package com.personal.movieplanet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.personal.movieplanet.enums.SeatType;
import com.personal.movieplanet.dto.ShowSeatsDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "show_seats")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class ShowSeat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "seat_number", nullable = false)
	private String seatNumber;

	@Column(name = "rate", nullable = false)
	private int rate;

	@Enumerated(EnumType.STRING)
	@Column(name = "seat_type", nullable = false)
	private SeatType seatType;

	@Column(name = "is_booked", nullable = false)
	private boolean booked;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "booked_at")
	@CreationTimestamp
	private Date bookedAt;

	@ManyToOne
	@JsonIgnore
	private Show show;

	@ManyToOne
	@JsonIgnore
	private Ticket ticket;

	public static List<ShowSeatsDto> toResource(List<ShowSeat> seats) {

		if (!CollectionUtils.isEmpty(seats)) {
			return seats.stream().map(ShowSeat::toResource).collect(Collectors.toList());
		}

		return new ArrayList<>();
	}

	public static ShowSeatsDto toResource(ShowSeat seatsEntity) {

		return ShowSeatsDto.builder()
				.id(seatsEntity.getId())
				.seatNumber(seatsEntity.getSeatNumber())
				.rate(seatsEntity.getRate())
				.seatType(seatsEntity.getSeatType())
				.booked(seatsEntity.isBooked())
				.bookedAt(seatsEntity.getBookedAt())
				.build();

	}

}