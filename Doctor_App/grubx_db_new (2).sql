-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 07, 2020 at 02:06 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `grubx_db_new`
--

-- --------------------------------------------------------

--
-- Table structure for table `business`
--

CREATE TABLE `business` (
  `id` int(11) NOT NULL,
  `users_id` int(11) NOT NULL,
  `business_name` varchar(45) DEFAULT NULL,
  `owner_name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `goods` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `business`
--

INSERT INTO `business` (`id`, `users_id`, `business_name`, `owner_name`, `address`, `goods`, `created_at`, `updated_at`) VALUES
(2, 21, 'food', 'raju1', 'hyd', 'food', '2020-02-06 10:32:47', '2020-02-07 05:20:28');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `users_id` int(11) NOT NULL,
  `products_id` int(11) NOT NULL,
  `created_on` timestamp NULL DEFAULT NULL,
  `updated_on` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `catalogue`
--

CREATE TABLE `catalogue` (
  `id` int(11) NOT NULL,
  `users_id` int(11) NOT NULL,
  `name` varchar(145) DEFAULT NULL,
  `created_on` timestamp NULL DEFAULT NULL,
  `updated_on` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `catalogue_products`
--

CREATE TABLE `catalogue_products` (
  `id` int(11) NOT NULL,
  `catalogue_id` int(11) NOT NULL,
  `products_id` int(11) NOT NULL,
  `created_on` timestamp NULL DEFAULT NULL,
  `updated_on` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `users_id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `users_id`, `name`, `created_at`, `updated_at`) VALUES
(4, 1, 'Baked goods', '2020-02-04 00:00:00', '2020-02-04 05:09:18'),
(5, 1, 'Meat & Poultry', '2020-02-04 00:00:00', '2020-02-04 05:09:55'),
(6, 1, 'Food', '2020-02-04 00:00:00', '2020-02-04 05:10:10'),
(7, 1, 'Sea Food', '2020-02-04 00:00:00', '2020-02-04 05:10:26'),
(8, 1, 'Beverages & Drinks', '2020-02-04 00:00:00', '2020-02-04 05:11:14');

-- --------------------------------------------------------

--
-- Table structure for table `failed_jobs`
--

CREATE TABLE `failed_jobs` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `connection` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `queue` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `payload` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `exception` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `failed_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2014_10_12_000000_create_users_table', 1),
(2, '2014_10_12_100000_create_password_resets_table', 1),
(3, '2016_06_01_000001_create_oauth_auth_codes_table', 1),
(4, '2016_06_01_000002_create_oauth_access_tokens_table', 1),
(5, '2016_06_01_000003_create_oauth_refresh_tokens_table', 1),
(6, '2016_06_01_000004_create_oauth_clients_table', 1),
(7, '2016_06_01_000005_create_oauth_personal_access_clients_table', 1),
(8, '2019_08_19_000000_create_failed_jobs_table', 1),
(9, '2020_02_04_150732_create_products_table', 2);

-- --------------------------------------------------------

--
-- Table structure for table `notifications`
--

CREATE TABLE `notifications` (
  `id` int(11) NOT NULL,
  `users_id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(245) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `oauth_access_tokens`
--

CREATE TABLE `oauth_access_tokens` (
  `id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` bigint(20) UNSIGNED DEFAULT NULL,
  `client_id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `scopes` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `revoked` tinyint(1) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `expires_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `oauth_access_tokens`
--

INSERT INTO `oauth_access_tokens` (`id`, `user_id`, `client_id`, `name`, `scopes`, `revoked`, `created_at`, `updated_at`, `expires_at`) VALUES
('2a9a6937b4c352781074499c8f8482cc6dcc4d9e47eb62658a045de5b0828130976954fd8f114686', 36, 1, 'MyApp', '[]', 0, '2020-02-07 07:06:27', '2020-02-07 07:06:27', '2021-02-07 12:36:27'),
('37e2f8ddf24663d8e95882741ceb6fef62ce3e12b61d256592cc7d2d159350d21d572ca2b8f9ef85', 19, 1, 'MyApp', '[]', 0, '2020-02-05 05:47:31', '2020-02-05 05:47:31', '2021-02-05 11:17:31'),
('37ef8c07a3fdd86dbb9dff973c8e57e15c7d37d6d4db7ed51af3f87f69abe9ae8ce9e05f6b662eae', 17, 1, 'MyApp', '[]', 0, '2020-02-05 03:27:27', '2020-02-05 03:27:27', '2021-02-05 08:57:27'),
('3b8bf65ad0a1ae05d5565537872f1ffeb7bc4abdb18204213a7623b8048a9801674570a6394fc8bd', 15, 1, 'MyApp', '[]', 0, '2020-02-05 03:45:22', '2020-02-05 03:45:22', '2021-02-05 09:15:22'),
('414ee3555eb3b081eb7876d11ceefd056622e1935c43b50aafe4ed4b8d8ddd87d1f5e748c986abc5', 33, 1, 'MyApp', '[]', 0, '2020-02-07 01:08:46', '2020-02-07 01:08:46', '2021-02-07 06:38:46'),
('4d9f27e169f6f4195fa60956ba6c6ebd65013e2c654729ed25540733a48c7f8ef8ecbcde6f7900fc', 33, 1, 'MyApp', '[]', 0, '2020-02-07 01:26:15', '2020-02-07 01:26:15', '2021-02-07 06:56:15'),
('502099e1a418214ad9aec4042d793894ae8be59d41dd044c1f18210d94524a2795e78c1560fa83cb', 30, 1, 'MyApp', '[]', 0, '2020-02-07 00:53:16', '2020-02-07 00:53:16', '2021-02-07 06:23:16'),
('50f0a086712b276af14854c002128de65f4870a51ba416a9bd5515563275159e7d266af3cd6ff2de', 15, 1, 'MyApp', '[]', 0, '2020-02-05 03:42:20', '2020-02-05 03:42:20', '2021-02-05 09:12:20'),
('51a04b0315ad882a945d216bbfd45bc285129467995e08afd0eebb4b8fe37258dfc9f4f76d797e61', 33, 1, 'MyApp', '[]', 0, '2020-02-07 01:23:18', '2020-02-07 01:23:18', '2021-02-07 06:53:18'),
('56f7b85ad6ddee204c1ce5427ee5cc18d50f49f8cc27f0078b7bd1a2cd1857557b4fc6a5a4f9aeac', 33, 1, 'MyApp', '[]', 0, '2020-02-07 04:00:31', '2020-02-07 04:00:31', '2021-02-07 09:30:31'),
('651fe602a27911ad66423a2059ecb2ae2185d1f4ac44d0e67f6e78bf0a28d1bde4a23aa5135f1b2b', 20, 1, 'MyApp', '[]', 0, '2020-02-05 22:54:01', '2020-02-05 22:54:01', '2021-02-06 04:24:01'),
('6e8d694df0c89e91a19109842260611b837ff4f6b0aaa227e5f4f8de3902e59aa650d7d2addc7e51', 15, 1, 'MyApp', '[]', 0, '2020-02-04 23:05:49', '2020-02-04 23:05:49', '2021-02-05 04:35:49'),
('6ed6d54fc5c50d846de524802c16d5b3935af3a52bf463afce10d11c6fc31dd14c9fcb22a60dc028', 22, 1, 'MyApp', '[]', 0, '2020-02-05 23:06:28', '2020-02-05 23:06:28', '2021-02-06 04:36:28'),
('7e3c108d6cef8e62b39aa62dc83c58fb28be1f93f388f5398d3e05e7b9643529cb1749957bd8dae2', 15, 1, 'MyApp', '[]', 0, '2020-02-05 03:16:32', '2020-02-05 03:16:32', '2021-02-05 08:46:32'),
('861a62b40c90bb26d704b4462867839ad2c8136470642ffaef4f448b35e5ea042339a16fec0b561f', 26, 1, 'MyApp', '[]', 0, '2020-02-06 23:49:22', '2020-02-06 23:49:22', '2021-02-07 05:19:22'),
('9032d5ccc9b78f63c7c37fc815d81107c509232c2305aee99ee8be9c6df88fca74f0243c9828d01d', 1, 1, 'MyApp', '[]', 0, '2020-02-04 10:21:04', '2020-02-04 10:21:04', '2021-02-04 15:51:04'),
('95b896eeeb7d0f6e4c728fc19c41148859ada40f6a99c927509d28da02ec32929d85b949279ba712', 32, 1, 'MyApp', '[]', 0, '2020-02-07 01:07:51', '2020-02-07 01:07:51', '2021-02-07 06:37:51'),
('9a6481b3032f3ecd5634638c28bf98f2e900a889e8d7b6afc8695d941174506f4eee57796d935ceb', 15, 1, 'MyApp', '[]', 0, '2020-02-05 22:45:44', '2020-02-05 22:45:44', '2021-02-06 04:15:44'),
('a1da5e912530a3c143448f97d4ca5d61671cf317110ad34b63968d3179832e7bc733f16c5e7086a0', 33, 1, 'MyApp', '[]', 0, '2020-02-07 01:19:46', '2020-02-07 01:19:46', '2021-02-07 06:49:46'),
('a5ec61b16d4e777f7f2e0ca11f4a9c5412315f7a8e7bbb6e707dbf015b8a617c242087e0232ca439', 1, 1, 'MyApp', '[]', 0, '2020-02-04 10:33:33', '2020-02-04 10:33:33', '2021-02-04 16:03:33'),
('a9656fcf92340125aee82688d73b4fa78381ef2592056a00dd2a30317d6975197a54bc12eb600f27', 15, 1, 'MyApp', '[]', 0, '2020-02-05 03:44:25', '2020-02-05 03:44:25', '2021-02-05 09:14:25'),
('ae35794bb6ef502551cd5652180dd8ed309c4f470eb7d0e09334a26236700f9586aa567ee7b454c0', 25, 1, 'MyApp', '[]', 0, '2020-02-06 23:09:01', '2020-02-06 23:09:01', '2021-02-07 04:39:01'),
('af0b1cccc1807621ec2053bd829cddfa7db4bae92339c2c5776a936242f17f2253c42e83af13848c', 2, 1, 'MyApp', '[]', 0, '2020-02-04 22:44:51', '2020-02-04 22:44:51', '2021-02-05 04:14:51'),
('c50cbb3716fcc9c842f549034579fccf69c9a3a38bfffab6fa81f4894ff8dabfd615469d4b03ced6', 15, 1, 'MyApp', '[]', 0, '2020-02-04 23:54:01', '2020-02-04 23:54:01', '2021-02-05 05:24:01'),
('dda24ccdc51d8f67262e29dc50c19860a30d014c810cf2b5497ef3263817189a174628995de29dd1', 21, 1, 'MyApp', '[]', 0, '2020-02-05 23:05:54', '2020-02-05 23:05:54', '2021-02-06 04:35:54'),
('df15757ae1f7187d1552e9c4c1cfcb2ac1fe52c8fda0cb84547560418476566379837a2132b03e97', 38, 1, 'MyApp', '[]', 0, '2020-02-07 07:09:58', '2020-02-07 07:09:58', '2021-02-07 12:39:58'),
('e635a80b19b4744a1ae6233667bbf646f4a7cfa9c9d3363328fc6297ed46e8094ab713ec90209242', 15, 1, 'MyApp', '[]', 0, '2020-02-05 03:38:22', '2020-02-05 03:38:22', '2021-02-05 09:08:22'),
('e752d6465e2c6bc77353bf67cd335a8f92ce3071a8680376fcb57e46b23be12c4e3c073130b26073', 31, 1, 'MyApp', '[]', 0, '2020-02-07 01:02:23', '2020-02-07 01:02:23', '2021-02-07 06:32:23'),
('eab1399602bc60ecedfb4b0151f2b84c36a9728856fd1b37d8132acacf4d734aa520b84a2d4a4a94', 15, 1, 'MyApp', '[]', 0, '2020-02-04 23:20:25', '2020-02-04 23:20:25', '2021-02-05 04:50:25'),
('f07b37f0fa7da6d751cade553cb09c8c1013854636996b9213b501d93415f6842204639e8e443586', 22, 1, 'MyApp', '[]', 0, '2020-02-05 23:06:11', '2020-02-05 23:06:11', '2021-02-06 04:36:11'),
('f138dacafd9b969294e483eecfbd7ae04b14779caebcf4d05c109ef1f8334cef4e5398475cc02852', 15, 1, 'MyApp', '[]', 0, '2020-02-05 01:42:37', '2020-02-05 01:42:37', '2021-02-05 07:12:37'),
('f4cc3c89023984f5c0f136c50c844c86028e6a9facfcac8f0b42338af6f8f96530ea91566eb9d591', 16, 1, 'MyApp', '[]', 0, '2020-02-05 01:55:05', '2020-02-05 01:55:05', '2021-02-05 07:25:05'),
('f6009acd8dfcf5d1c0afd02ac0b93e944f419a4cc6599f19a8d8099b7c4abf1b64030feba90d5dca', 15, 1, 'MyApp', '[]', 0, '2020-02-04 23:02:57', '2020-02-04 23:02:57', '2021-02-05 04:32:57'),
('f90405784d67c6d03f3085be0a7adebfeeb7f70d27933c7771fdaf1cdb8117dfffc21a0a324df090', 33, 1, 'MyApp', '[]', 0, '2020-02-07 03:26:13', '2020-02-07 03:26:13', '2021-02-07 08:56:13'),
('fbc1f357935478e0588d8e8a7ffab6c71f361627932ad823fac1679e6d9ffaa6b6b06cb27d844195', 18, 1, 'MyApp', '[]', 0, '2020-02-05 05:14:40', '2020-02-05 05:14:40', '2021-02-05 10:44:40');

-- --------------------------------------------------------

--
-- Table structure for table `oauth_auth_codes`
--

CREATE TABLE `oauth_auth_codes` (
  `id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `client_id` bigint(20) UNSIGNED NOT NULL,
  `scopes` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `revoked` tinyint(1) NOT NULL,
  `expires_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `oauth_clients`
--

CREATE TABLE `oauth_clients` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `user_id` bigint(20) UNSIGNED DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `secret` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `redirect` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `personal_access_client` tinyint(1) NOT NULL,
  `password_client` tinyint(1) NOT NULL,
  `revoked` tinyint(1) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `oauth_clients`
--

INSERT INTO `oauth_clients` (`id`, `user_id`, `name`, `secret`, `redirect`, `personal_access_client`, `password_client`, `revoked`, `created_at`, `updated_at`) VALUES
(1, NULL, 'Laravel Personal Access Client', 'UhMrtq4IGBqiU8q8ZeF1aPysCZTXUTUUAxj6OMUc', 'http://localhost', 1, 0, 0, '2020-02-04 09:34:35', '2020-02-04 09:34:35'),
(2, NULL, 'Laravel Password Grant Client', '54VCJhPvAw2gnjaLVngAGSCOv2ssnsgBuqDI5tRN', 'http://localhost', 0, 1, 0, '2020-02-04 09:34:36', '2020-02-04 09:34:36');

-- --------------------------------------------------------

--
-- Table structure for table `oauth_personal_access_clients`
--

CREATE TABLE `oauth_personal_access_clients` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `client_id` bigint(20) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `oauth_personal_access_clients`
--

INSERT INTO `oauth_personal_access_clients` (`id`, `client_id`, `created_at`, `updated_at`) VALUES
(1, 1, '2020-02-04 09:34:36', '2020-02-04 09:34:36');

-- --------------------------------------------------------

--
-- Table structure for table `oauth_refresh_tokens`
--

CREATE TABLE `oauth_refresh_tokens` (
  `id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `access_token_id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `revoked` tinyint(1) NOT NULL,
  `expires_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `users_id` int(11) NOT NULL,
  `products_id` int(11) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `txn_number` varchar(45) DEFAULT NULL,
  `payment_mode` varchar(45) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `password_resets`
--

CREATE TABLE `password_resets` (
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `users_id` int(11) NOT NULL,
  `categories_id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `stock` varchar(45) DEFAULT NULL,
  `offer_price` varchar(45) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `is_featured` varchar(45) DEFAULT NULL,
  `cover_image` varchar(45) DEFAULT NULL,
  `productscol` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `product_images`
--

CREATE TABLE `product_images` (
  `id` int(11) NOT NULL,
  `products_id` int(11) NOT NULL,
  `image_url` varchar(245) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `sub_categories`
--

CREATE TABLE `sub_categories` (
  `id` int(11) NOT NULL,
  `users_id` int(11) NOT NULL,
  `categories_id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sub_categories`
--

INSERT INTO `sub_categories` (`id`, `users_id`, `categories_id`, `name`, `status`, `created_at`, `updated_at`) VALUES
(1, 1, 6, 'Sea Food', NULL, '0000-00-00 00:00:00', '2020-02-12 00:00:00'),
(2, 1, 6, 'Fruit and vegetables', NULL, '2020-02-12 00:00:00', '2020-02-12 00:00:00'),
(3, 1, 6, 'Fats and sugars', NULL, '2020-02-12 00:00:00', '2020-02-12 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `address` varchar(145) DEFAULT NULL,
  `pincode` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `remember_token` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `api_token` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `type`, `name`, `phone`, `email`, `email_verified_at`, `address`, `pincode`, `password`, `remember_token`, `created_at`, `updated_at`, `api_token`) VALUES
(1, '1', 'Admin', NULL, 'admin@admin.com', NULL, NULL, NULL, '$2y$10$dl9NEqToQqbma9HFtKRc0O9lQ0NTmcKXIHd0qmVlkrAEPLN8/Uytm', 'tqWnVr1Wd9UVbqo7R4VZm5u8xxwHgWLZejynbM9p6RN5bJhwUv9dQvOSwmEp', '2020-01-30 01:14:35', '2020-01-30 01:14:35', ''),
(21, '2', 'raju2', '9542254408', 'test2@gmail.com', NULL, 'hyd', '123456', '$2y$10$eAf1ZhDr2kb661gmmUe8YeUstaOJympRaqX7VDemRkm55.aIEkBca', NULL, '2020-02-05 23:05:54', '2020-02-07 06:45:38', NULL),
(22, '3', 'raju', '9542254409', 'test@gmail.com', NULL, 'hyd', '123456', '$2y$10$5oPYXQ2ZCKceLn/OwyRTAeAMMPAP3CGzUrsDw96vZ/Yyw7u1RxRde', NULL, '2020-02-05 23:06:11', '2020-02-07 01:37:27', NULL),
(25, '2', 'raju2', '9542254400', 'test3@gmail.com', NULL, 'hyd', '123456', '$2y$10$9/SINznR7ei8dsOHzp/3Aeagyx3U5X6hMarkzjxHhC2h/2YrGl8Z.', NULL, '2020-02-06 23:09:00', '2020-02-06 23:09:00', NULL),
(26, '4', 'mahesh', '8688483215', 'bmahesh@gmail.com', NULL, NULL, NULL, '$2y$10$gYtysaEir5VDqJNb2hoyL.FViEvElqdEHxY4hzx41R2DXg0P0nhgS', NULL, '2020-02-06 23:49:22', '2020-02-06 23:49:22', NULL),
(30, '2', 'raju', '9542254403', 'tes22d4t@gmail.com', NULL, 'hyd', '123456', '$2y$10$xw7h8HpCD.hxhYV2SvAxiOhSFHM4bDe.Wn5o5Ybpl2JCodb54WaAq', NULL, '2020-02-07 00:53:16', '2020-02-07 00:53:16', NULL),
(31, '2', 'r', '2356897410', 't@gmail.com', NULL, NULL, NULL, '$2y$10$h6VdRS4Z1EiQhLIAtt6Gb.lH7ATYtjGCAkx1oZU3y83ghj3NPCDAK', NULL, '2020-02-07 01:02:22', '2020-02-07 01:02:22', NULL),
(32, '4', 'maheshreddy', '123456789', 'gangamahesh@gmail.com', NULL, NULL, NULL, '$2y$10$t04QErTECt8uTxv9C56uxuj/iWLA9NGTWbh7N61wsik.6KjL4XN2i', NULL, '2020-02-07 01:07:51', '2020-02-07 01:07:51', NULL),
(33, '4', 'harish', '2343215676', 'harish@gmail.com', NULL, NULL, NULL, '$2y$10$7/YzdpN1bw6Xwdr/UI29KeRqKV.SOtVXskWIidXQU16.0wh4VuDli', NULL, '2020-02-07 01:08:45', '2020-02-07 01:08:45', NULL),
(34, '2', 'abc', 'a', 'a@a.com', NULL, NULL, NULL, '$2y$10$sAzNFBXD9r0wFghN8QNYIuUFQ9cNFyqRIFESBBYnj.lLzNd9toaUK', NULL, '2020-02-07 06:32:43', '2020-02-07 06:32:43', NULL),
(35, '2', 'abc2', '123', 'b@b.com', NULL, NULL, NULL, '$2y$10$E1DgXReSBrx31WN6YseN6OEKnRz0rbbIXASaGB0WfJu5JNDs4WeUS', NULL, '2020-02-07 06:33:36', '2020-02-07 06:33:36', NULL),
(36, '4', 'vikas', '8978098756', 'grj@gmail.com', NULL, NULL, NULL, '$2y$10$ZZp4EiqWd7VhWHYcAB/SFu5mX8646H1KKe43esoQSf9onGcIUsbPu', NULL, '2020-02-07 07:06:27', '2020-02-07 07:06:27', NULL),
(38, '4', 'mahesh', '9542354409', 'test56@gmail.com', NULL, 'hyd', '123456', '$2y$10$JILfQvGiz5Px3omxGWa5MOIcGh972vkg1S7wcRg7PQRPuKi4v2M.m', NULL, '2020-02-07 07:09:58', '2020-02-07 07:09:58', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `whislist`
--

CREATE TABLE `whislist` (
  `id` int(11) NOT NULL,
  `users_id` int(11) NOT NULL,
  `products_id` int(11) NOT NULL,
  `created_on` timestamp NULL DEFAULT NULL,
  `updated_on` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `business`
--
ALTER TABLE `business`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_business_users1_idx` (`users_id`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_cart_users1_idx` (`users_id`),
  ADD KEY `fk_cart_products1_idx` (`products_id`);

--
-- Indexes for table `catalogue`
--
ALTER TABLE `catalogue`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_catalogue_users1_idx` (`users_id`);

--
-- Indexes for table `catalogue_products`
--
ALTER TABLE `catalogue_products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_catalogue_products_catalogue1_idx` (`catalogue_id`),
  ADD KEY `fk_catalogue_products_products1_idx` (`products_id`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_categories_users1_idx` (`users_id`);

--
-- Indexes for table `failed_jobs`
--
ALTER TABLE `failed_jobs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `notifications`
--
ALTER TABLE `notifications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_notifications_users1_idx` (`users_id`);

--
-- Indexes for table `oauth_access_tokens`
--
ALTER TABLE `oauth_access_tokens`
  ADD PRIMARY KEY (`id`),
  ADD KEY `oauth_access_tokens_user_id_index` (`user_id`);

--
-- Indexes for table `oauth_auth_codes`
--
ALTER TABLE `oauth_auth_codes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `oauth_auth_codes_user_id_index` (`user_id`);

--
-- Indexes for table `oauth_clients`
--
ALTER TABLE `oauth_clients`
  ADD PRIMARY KEY (`id`),
  ADD KEY `oauth_clients_user_id_index` (`user_id`);

--
-- Indexes for table `oauth_personal_access_clients`
--
ALTER TABLE `oauth_personal_access_clients`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `oauth_refresh_tokens`
--
ALTER TABLE `oauth_refresh_tokens`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_orders_users1_idx` (`users_id`),
  ADD KEY `fk_orders_products1_idx` (`products_id`);

--
-- Indexes for table `password_resets`
--
ALTER TABLE `password_resets`
  ADD KEY `password_resets_email_index` (`email`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_products_categories_idx` (`categories_id`),
  ADD KEY `fk_products_users1_idx` (`users_id`);

--
-- Indexes for table `product_images`
--
ALTER TABLE `product_images`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_product_images_products1_idx` (`products_id`);

--
-- Indexes for table `sub_categories`
--
ALTER TABLE `sub_categories`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_products_categories_idx` (`categories_id`),
  ADD KEY `fk_products_users1_idx` (`users_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `phone` (`phone`);

--
-- Indexes for table `whislist`
--
ALTER TABLE `whislist`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_whislist_users1_idx` (`users_id`),
  ADD KEY `fk_whislist_products1_idx` (`products_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `business`
--
ALTER TABLE `business`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `catalogue`
--
ALTER TABLE `catalogue`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `catalogue_products`
--
ALTER TABLE `catalogue_products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `failed_jobs`
--
ALTER TABLE `failed_jobs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `notifications`
--
ALTER TABLE `notifications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `oauth_clients`
--
ALTER TABLE `oauth_clients`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `oauth_personal_access_clients`
--
ALTER TABLE `oauth_personal_access_clients`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `product_images`
--
ALTER TABLE `product_images`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sub_categories`
--
ALTER TABLE `sub_categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `whislist`
--
ALTER TABLE `whislist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `business`
--
ALTER TABLE `business`
  ADD CONSTRAINT `fk_business_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `fk_cart_products1` FOREIGN KEY (`products_id`) REFERENCES `products` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_cart_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `catalogue`
--
ALTER TABLE `catalogue`
  ADD CONSTRAINT `fk_catalogue_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `catalogue_products`
--
ALTER TABLE `catalogue_products`
  ADD CONSTRAINT `fk_catalogue_products_catalogue1` FOREIGN KEY (`catalogue_id`) REFERENCES `catalogue` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_catalogue_products_products1` FOREIGN KEY (`products_id`) REFERENCES `products` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `categories`
--
ALTER TABLE `categories`
  ADD CONSTRAINT `categories_ibfk_1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `notifications`
--
ALTER TABLE `notifications`
  ADD CONSTRAINT `fk_notifications_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_orders_products1` FOREIGN KEY (`products_id`) REFERENCES `products` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_orders_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `fk_products_categories` FOREIGN KEY (`categories_id`) REFERENCES `categories` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_products_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `product_images`
--
ALTER TABLE `product_images`
  ADD CONSTRAINT `fk_product_images_products1` FOREIGN KEY (`products_id`) REFERENCES `products` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `sub_categories`
--
ALTER TABLE `sub_categories`
  ADD CONSTRAINT `sub_categories_ibfk_1` FOREIGN KEY (`categories_id`) REFERENCES `categories` (`id`),
  ADD CONSTRAINT `sub_categories_ibfk_2` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `whislist`
--
ALTER TABLE `whislist`
  ADD CONSTRAINT `fk_whislist_products1` FOREIGN KEY (`products_id`) REFERENCES `products` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_whislist_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
