-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-12-2020 a las 17:54:28
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `activitat1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumne`
--

CREATE TABLE `alumne` (
  `Id` int(11) NOT NULL,
  `nom` text COLLATE utf8_spanish_ci NOT NULL,
  `dni` text COLLATE utf8_spanish_ci NOT NULL,
  `data_naixement` text COLLATE utf8_spanish_ci NOT NULL,
  `codi_poblacio` text COLLATE utf8_spanish_ci NOT NULL,
  `codi_postal` int(5) NOT NULL,
  `poblacio` text COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `alumne`
--

INSERT INTO `alumne` (`Id`, `nom`, `dni`, `data_naixement`, `codi_poblacio`, `codi_postal`, `poblacio`) VALUES
(1, 'Alex', '39922761M', '11/07/1997', 'Carrermora', 43205, 'Reus'),
(2, 'Hector', '3333444R', '15/02/2001', 'CarrerP', 43222, 'Valls'),
(3, 'Dani', '39922760K', '24/12/2001', 'Fe', 43235, 'Salou');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `poblacio`
--

CREATE TABLE `poblacio` (
  `codi_postal` int(5) NOT NULL,
  `poblacio` text COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `poblacio`
--

INSERT INTO `poblacio` (`codi_postal`, `poblacio`) VALUES
(43205, 'Reus'),
(43222, 'Valls'),
(43235, 'Salou');
--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumne`
--
ALTER TABLE `alumne`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `alumne_ibfk_1` (`codi_postal`);

--
-- Indices de la tabla `poblacio`
--
ALTER TABLE `poblacio`
  ADD PRIMARY KEY (`codi_postal`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumne`
--
ALTER TABLE `alumne`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumne`
--
ALTER TABLE `alumne`
  ADD CONSTRAINT `alumne_ibfk_1` FOREIGN KEY (`codi_postal`) REFERENCES `poblacio` (`codi_postal`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
