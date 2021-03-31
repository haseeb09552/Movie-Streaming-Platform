import { Component, OnInit } from '@angular/core';
import { MoviesService } from './../movies.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-movie-detail',
  templateUrl: './movie-detail.component.html',
  styleUrls: ['./movie-detail.component.css'],
})
export class MovieDetailComponent implements OnInit {
  id: any;
  movie: any = {};

  constructor(
    private _moviesService: MoviesService,
    private _route: ActivatedRoute
  ) {
    this._route.params.subscribe((params) => (this.id = params.id));
  }

  ngOnInit(): void {
    this._moviesService.getMovieById(this.id).subscribe(
      (res) => {
        this.movie = res;
        console.log(res);
      },
      (err) => console.log(err)
    );
  }
}
