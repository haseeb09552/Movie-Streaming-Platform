import { MoviesService } from './../movies.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css'],
})
export class MovieListComponent implements OnInit {
  movies: any = [];
  constructor(private _moviesService: MoviesService) {}

  ngOnInit(): void {
    this._moviesService.getMovies().subscribe(
      (res) => (this.movies = res),
      (err) => console.log(err)
    );
  }
}
