import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ProductService, Product } from '../../services/product.service';

@Component({
  selector: 'app-product-list',
  standalone: true, // Importante
  imports: [CommonModule, RouterModule], // Importar módulos necesarios
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css'],
})
export class ProductListComponent {
  products: Product[] = [];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.productService.getProducts().subscribe((data) => {
      this.products = data;
    });
  }

  deleteProduct(id: string): void {
    this.productService.deleteProduct(id).subscribe(() => {
      this.loadProducts();
    });
  }
}
