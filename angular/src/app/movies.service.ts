import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class MoviesService {
  private _moviesUrl = 'http://localhost:8080/movie';

  constructor(private http: HttpClient) {}

  getMovies() {
    return this.http.get<any>(this._moviesUrl);
  }

  getMovieById(id: any) {
    return this.http.get<any>(this._moviesUrl + '/' + id);
  }
}
