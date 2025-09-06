package com.personal.movieplanet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.personal.movieplanet.dto.ReviewDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name="review_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Review {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;

    private String movieReview;

    private double rating;

    @ManyToOne
    @JoinColumn(name="movie_id", nullable=false)
    @JsonIgnore
    private Movie movie; // it will add foregion key in mysql table with <TABLE_NAME>_<ID_NAME> --> // movie_movie_id

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;


    public static Review toEntity(ReviewDto reviewResource){
        return Review.builder().movieReview(reviewResource.getMovieReview()).rating(reviewResource.getRating()).movie(Movie.builder().id(reviewResource.getMovieId()).build()).build();
    }

    public static ReviewDto toResource(Review review){
        return ReviewDto.builder().movieReview(review.getMovieReview()).rating(review.getRating()).movieId(review.getMovie().getId()).build();
    }

    public static List<ReviewDto> toResource(List<Review> reviews){
             if(CollectionUtils.isEmpty(reviews))
                 return new ArrayList<>();
             else
                 return reviews.stream().map(Review::toResource).collect(Collectors.toList()); 
    }

}
