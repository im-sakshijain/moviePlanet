package com.personal.movieplanet.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class ShowDto {

	private long id;

	@NotNull(message = "Show Time is Mandatory")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime showTime;

	@NotNull(message = "Movie is Mandatory for Show")
	private long movieId;

	@NotNull(message = "Theater is Mandatory for Show")
	private long theaterId;

	private Date createdAt;

	private Date updatedAt;

	private MovieDto movieResource;

	private TheaterDto theaterResource;

	private List<ShowSeatsDto> seats;
}